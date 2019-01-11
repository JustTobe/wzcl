package com.kcsj.wzcl.controller;

import com.kcsj.wzcl.bean.Operation;
import com.kcsj.wzcl.service.serviceImple.OperationService;
import com.kcsj.wzcl.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OperationController {
    @Autowired
    private OperationService operationService;

    //添加一条操作记录
    @PostMapping("/operations")
    public Result add(@RequestBody Operation operation)
    {
        return operationService.add(operation);
    }

    //获取某个管理员处理违章
    @GetMapping("/operations/self")
    public Result getByAdminName(@PathVariable String adminName)
    {
        return operationService.getByAdminName(adminName);
    }
    //获取对某个违章事件的操作记录
    @GetMapping("/operations/{vioId}")
    public Result getByVioId(@PathVariable int vioId)
    {
        return operationService.getByVioId(vioId);
    }
}
