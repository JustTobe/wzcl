package com.kcsj.wzcl.controller;

import com.kcsj.wzcl.bean.Vehicle;
import com.kcsj.wzcl.service.serviceImple.VehicleService;
import com.kcsj.wzcl.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class VehicleController {

    @Autowired private VehicleService vehicleService;


    /*
    根据车牌查询车辆登记信息
     */

    @GetMapping(value="/vehicles/{plate}")
    public Result get(@PathVariable String plate)
    {
        return vehicleService.get(plate);
    }


    /*
    获取全部登记车辆信息

     */
    @GetMapping(value="/vehicles")
    public Result list()
    {
        return vehicleService.getAll();
    }


    /*
    登记车辆
     */
    @PostMapping("/vehicles")
    public Result add(@RequestBody Vehicle vehicle)
    {
       return vehicleService.add(vehicle);
    }

    //按车牌删除
    @DeleteMapping("/vehicles/{plate}")
    public Result delete(@PathVariable String plate)
    {
       return vehicleService.delete(plate);
    }




}
