package com.kcsj.wzcl.controller;

import com.kcsj.wzcl.bean.Vehicle;
import com.kcsj.wzcl.service.VehicleService;
import com.kcsj.wzcl.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class VehicleController {

    @Autowired private VehicleService vehicleService;


    /*
    根据车牌查询车辆登记信息
     */
    @GetMapping("/vehicles/{plate}")
    public Result get(@RequestParam String plate)
    {
        return vehicleService.get(plate);
    }


    /*
    获取全部登记车辆信息
     */
    @GetMapping("/vehicles")
    public Result list()
    {
        return vehicleService.getAll();
    }


    /*
    登记车辆
     */
    @PostMapping("vehicles/addone")
    public Result add(@RequestBody Vehicle vehicle)
    {
       return vehicleService.add(vehicle);
    }

    //按车牌删除
    @DeleteMapping("vehicles/delete")
    public Result delete(@RequestParam String plate)
    {
       return vehicleService.delete(plate);
    }




}
