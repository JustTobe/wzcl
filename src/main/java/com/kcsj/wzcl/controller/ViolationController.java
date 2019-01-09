package com.kcsj.wzcl.controller;

import com.kcsj.wzcl.bean.Violation;
import com.kcsj.wzcl.service.ViolationService;
import com.kcsj.wzcl.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


@RestController
public class ViolationController {
    @Autowired
    private ViolationService violationService;

    //添加一条违章记录
    @PostMapping("violations")
    public Result add(Violation violation)
    {
        return violationService.add(violation);
    }

    @PostMapping("violations/pic")
    public Result upload(@RequestParam("file") MultipartFile file)
    {
        return violationService.upload(file);
    }

}
