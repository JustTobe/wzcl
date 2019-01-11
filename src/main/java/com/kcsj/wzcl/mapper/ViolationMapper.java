package com.kcsj.wzcl.mapper;

import com.kcsj.wzcl.bean.Violation;
import com.kcsj.wzcl.bean.ViolationExample;
import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ViolationMapper {
    int countByExample(ViolationExample example);

    int deleteByExample(ViolationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Violation record);

    int insertSelective(Violation record);

    List<Violation> selectByExample(ViolationExample example);

    Violation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Violation record, @Param("example") ViolationExample example);

    int updateByExample(@Param("record") Violation record, @Param("example") ViolationExample example);

    int updateByPrimaryKeySelective(Violation record);

    int updateByPrimaryKey(Violation record);
}