package com.kcsj.wzcl.controller;

import com.kcsj.wzcl.service.MessageService;
import com.kcsj.wzcl.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/messageRecord")
@RestController
public class MessageRecordController {

    @Autowired
    private MessageService messageService;

    @GetMapping(value = "/{id}")
    public Result getOne(@PathVariable int id){
       return  messageService.getById(id);
    }

    @PostMapping(value = "")
    public Result getAll(@RequestParam int page , @RequestParam int size){
        return messageService.getAll(page ,size);
    }
}
