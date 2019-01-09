package com.kcsj.wzcl.service;

import com.kcsj.wzcl.bean.Operation;
import com.kcsj.wzcl.mapper.OperationMapper;
import com.kcsj.wzcl.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService {
    @Autowired
    private OperationMapper operationMapper;

    //按管理员查询操作记录
    public Result listByType()
    {
        return Result.Success();
    }

    //按违章事件查询管理员操作记录vio_id

    //添加一条操作记录
    public Result add(Operation operation)
    {
        if(operationMapper.insert(operation)==0)
            return Result.Fail();
        return Result.Success();

    }
}
