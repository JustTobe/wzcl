package com.kcsj.wzcl.mapper;

import com.kcsj.wzcl.bean.MessageRecord;
import com.kcsj.wzcl.bean.MessageRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageRecordMapper {
    int countByExample(MessageRecordExample example);

    int deleteByExample(MessageRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MessageRecord record);

    int insertSelective(MessageRecord record);

    List<MessageRecord> selectByExample(MessageRecordExample example);

    MessageRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MessageRecord record, @Param("example") MessageRecordExample example);

    int updateByExample(@Param("record") MessageRecord record, @Param("example") MessageRecordExample example);

    int updateByPrimaryKeySelective(MessageRecord record);

    int updateByPrimaryKey(MessageRecord record);
}