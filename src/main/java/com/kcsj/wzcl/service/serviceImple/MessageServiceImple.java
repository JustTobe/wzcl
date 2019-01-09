package com.kcsj.wzcl.service.serviceImple;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kcsj.wzcl.bean.MessageRecord;
import com.kcsj.wzcl.mapper.MessageRecordMapper;
import com.kcsj.wzcl.service.MessageService;
import com.kcsj.wzcl.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImple implements MessageService {
    @Autowired
    private MessageRecordMapper mapper;

    @Override
    public Result getById(int id) {
        MessageRecord record = mapper.selectByPrimaryKey(id);

        return Result.add(record);
    }

    @Override
    public Result getAll(int page, int size) {
        PageHelper.startPage(page, size);
        List<MessageRecord> list = mapper.selectByExample(null);
        PageInfo pageInfo = new PageInfo(list);
        return Result.add(pageInfo);
    }
}
