package com.kcsj.wzcl.controller;

import com.kcsj.wzcl.bean.Regular;
import com.kcsj.wzcl.service.RegularService;
import com.kcsj.wzcl.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegularContronller {
    @Autowired
    private RegularService regularService;

    @GetMapping(value = "/regular/{id}")
    public Result getOne(@PathVariable int id){
        return regularService.getById(id);
    }
    @GetMapping(value = "/regulars")
    public Result getAll(){
        return regularService.getAll();
    }
    @DeleteMapping(value = "/regular/{id}")
    public  Result deleteOne(@PathVariable int id){
        return regularService.deleteById(id);

    }

    @PostMapping(value = "/regular")
    public Result addOne(@RequestBody Regular regular){
        return regularService.addOne(regular);
    }
}
