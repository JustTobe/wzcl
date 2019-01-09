package com.kcsj.wzcl.controller;

import com.kcsj.wzcl.bean.Operation;
import com.kcsj.wzcl.service.OperationService;
import com.kcsj.wzcl.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationController {
    @Autowired
    private OperationService operationService;

    //添加一条操作记录
    @PostMapping("/operations/add")
    public Result add(@RequestBody Operation operation)
    {
        return operationService.add(operation);
    }
}
