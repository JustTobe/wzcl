package com.kcsj.wzcl.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kcsj.wzcl.bean.*;
import com.kcsj.wzcl.mapper.ViolationMapper;
import com.kcsj.wzcl.service.AdminService;
import com.kcsj.wzcl.utils.Result;
import com.kcsj.wzcl.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController


public class LoginController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public Result login(@RequestParam String username,@RequestParam String password){
        Admin admin = adminService.getById(username);
        Result result = new Result();
        if(admin==null){
            result.setStatusCode(100);
            result.setDescription("请注册");
        }else {
            String pass=admin.getPassword();
            if(password.equals(pass)){
                String token = TokenUtils.createJwt("zhy",username,admin.getType());
                String type = admin.getType();
                String name =admin.getUserName();
                MyToken myToken = new MyToken(type,name,token,username);
                result.setData(myToken);
                result.setStatusCode(200);
            }else {
                result.setStatusCode(100);
                result.setDescription("用户名或密码错误");
            }
        }
        return result;
    }

    @PostMapping("logout")
    public Result logout(){
        return Result.Success();
    }



    @PostMapping("/admin/byType")
    public Result getByType(@RequestParam String type,@RequestParam int page ,@RequestParam int size){
        return adminService.getByType(type,page,size);
    }
    @PostMapping("/admins")
    public Result getAll(@RequestParam int page ,@RequestParam int size){
        return adminService.getAll(page,size);
    }
    @GetMapping("/admin/{username}")
    public Result getById(@PathVariable String username){
        Admin admin = adminService.getById(username);
        adminService.offPassword(admin);
        return Result.add(admin);

    }

}
