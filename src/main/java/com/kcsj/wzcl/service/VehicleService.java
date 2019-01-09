package com.kcsj.wzcl.service;

import com.kcsj.wzcl.bean.Vehicle;
import com.kcsj.wzcl.bean.VehicleExample;
import com.kcsj.wzcl.mapper.VehicleMapper;
import com.kcsj.wzcl.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService{
    @Autowired
    private VehicleMapper vehicleMapper;

    public Result get(String plate)
    {
        //根据车牌查询车主姓名、联系方式等登记信息
        VehicleExample ve=new VehicleExample();
        ve.or().andPlateEqualTo(plate);


        List<Vehicle> vehicles= vehicleMapper.selectByExample(ve);
        //System.out.println(vehicles.isEmpty()+"\n\n");


        if(vehicles.isEmpty())
        {
            return Result.Fail();      }

        Result result=new Result();
        result.setStatusCode(200);
        result.setData(vehicles);
        result.setDescription("test");
        return result;
    }

    public Result getAll()
    {
        VehicleExample ve=new VehicleExample();
        ve.or().andIdGreaterThan(0);
        List<Vehicle> vehicles=vehicleMapper.selectByExample(ve);

        Result result=new Result();
        result.setStatusCode(200);
        result.setData(vehicles);
        return result;
    }

    public Result add(Vehicle vehicle)
    {
        //vehicle.setCount(0);
        //vehicle.setGrade(0);
        if(vehicleMapper.insert(vehicle)==0)
            return Result.Fail();
        return Result.Success();
    }

    public Result delete(String plate)
    {
        VehicleExample ve=new VehicleExample();
        ve.or().andPlateEqualTo(plate);
        if(vehicleMapper.deleteByExample(ve)==0)
            return Result.Fail();
        return Result.Success();
    }
}
