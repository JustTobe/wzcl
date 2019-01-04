package com.kcsj.wzcl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PeccancyMapper {
    int countByExample(PeccancyExample example);

    int deleteByExample(PeccancyExample example);

    int deleteByPrimaryKey(Integer peccancyId);

    int insert(Peccancy record);

    int insertSelective(Peccancy record);

    List<Peccancy> selectByExample(PeccancyExample example);

    Peccancy selectByPrimaryKey(Integer peccancyId);

    int updateByExampleSelective(@Param("record") Peccancy record, @Param("example") PeccancyExample example);

    int updateByExample(@Param("record") Peccancy record, @Param("example") PeccancyExample example);

    int updateByPrimaryKeySelective(Peccancy record);

    int updateByPrimaryKey(Peccancy record);
}