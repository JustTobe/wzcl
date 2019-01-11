package com.kcsj.wzcl.controller;

import com.kcsj.wzcl.bean.Violation;
import com.kcsj.wzcl.service.serviceImple.ViolationService;
import com.kcsj.wzcl.utils.Result;
import com.sun.media.jfxmedia.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;


@RestController
public class ViolationController {
    @Autowired
    private ViolationService violationService;

    //上传图片
    @PostMapping("violations/pic")
    public Result upload(@RequestParam("file") MultipartFile file)
    {
        return violationService.upload(file);
    }

    //显示图片,produces = MediaType.IMAGE_JPEG_VALUE

    @GetMapping(value="/violations/pic/{name}",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] showPic(@PathVariable String name)
    {
        return violationService.showPic(name);
    }
    //public showImg(HttpServletRequest )

    //添加一条违章记录
    @PostMapping("/violations")
    public Result add(@RequestBody Violation violation)
    {
        return violationService.add(violation);
    }
    //获取车辆违章历史
    @GetMapping("/violations/{plate}")
    public Result getHistory(@PathVariable String plate)
    {
        return violationService.getHistory(plate);
    }
    //修改违章记录
    @PutMapping("/violations")
    public Result putStatus(@RequestBody Violation vio)
    {
        return violationService.putStatus(vio);
    }

    //违章上报
    @PostMapping("/violations/submit")
    public Result submit(@RequestBody Map<String,Object> map)
    {
        //System.out.println(map.get("status"));

        return violationService.submit(map);
    }
    //初步确认
    @PostMapping("/violations/preConfirm")
    public Result preConfirm(@RequestBody Map<String,Object> map)
    {
        return violationService.preConfirm(map);
    }
    //最终确认
    @PostMapping("/violations/finalConfirm")
    public Result finalConfirm(@RequestBody Map<String,Object> map)
    {
        return violationService.finalConfirm(map);
    }
    //撤销
    @PostMapping("/violations/cancel")
    public Result cancel(@RequestBody Map<String,Object> map)
    {
        return violationService.cancel(map);
    }

}
