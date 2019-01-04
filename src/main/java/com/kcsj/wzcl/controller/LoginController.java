package com.kcsj.wzcl.controller;

import com.kcsj.wzcl.utils.Result;
import com.kcsj.wzcl.utils.TokenUtils;
import io.jsonwebtoken.JwtBuilder;
import org.springframework.web.bind.annotation.*;

@RestController


public class LoginController {
    @RequestMapping("/login")
    public Result login(@RequestParam String username){
        if(username.equals("zhy")){
           String token = TokenUtils.createJwt("zhy",username,"admin");
           return  Result.add(token);
        }
        return  Result.Fail();
    }
}
