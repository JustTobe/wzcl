package com.kcsj.wzcl.service.serviceImple;

import com.kcsj.wzcl.bean.Operation;
import com.kcsj.wzcl.bean.OperationExample;
import com.kcsj.wzcl.mapper.OperationMapper;
import com.kcsj.wzcl.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {
    @Autowired
    private OperationMapper operationMapper;

    //添加一条操作记录
    public Result add(Operation operation)
    {
        if(operationMapper.insert(operation)==0)
            return Result.Fail();
        return Result.Success();
    }

    public Result getByAdminName(String adminName)
    {
        OperationExample oe=new OperationExample();
        oe.or().andAdminNameEqualTo(adminName);
        List<Operation> operations=operationMapper.selectByExample(oe);
        if(operations.isEmpty())
            return Result.Fail();

        Result result=new Result();
        result.setData(operations);
        result.setStatusCode(200);
        return result;
    }

    public Result getByVioId(int vioId)
    {
        OperationExample oe=new OperationExample();
        oe.or().andVioIdEqualTo(vioId);
        List<Operation> operations=operationMapper.selectByExample(oe);
        if(operations.isEmpty())
            return Result.Fail();
        return Result.add(operations);
    }


}
