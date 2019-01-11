package com.kcsj.wzcl.mapper;

import com.kcsj.wzcl.bean.Vehicle;
import com.kcsj.wzcl.bean.VehicleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VehicleMapper {
    int countByExample(VehicleExample example);

    int deleteByExample(VehicleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Vehicle record);

    int insertSelective(Vehicle record);

    List<Vehicle> selectByExample(VehicleExample example);

    Vehicle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Vehicle record, @Param("example") VehicleExample example);

    int updateByExample(@Param("record") Vehicle record, @Param("example") VehicleExample example);

    int updateByPrimaryKeySelective(Vehicle record);

    int updateByPrimaryKey(Vehicle record);
}