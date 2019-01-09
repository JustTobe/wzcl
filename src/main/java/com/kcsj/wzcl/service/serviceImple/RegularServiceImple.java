package com.kcsj.wzcl.service.serviceImple;

import com.kcsj.wzcl.bean.Regular;
import com.kcsj.wzcl.bean.RegularExample;
import com.kcsj.wzcl.mapper.RegularMapper;
import com.kcsj.wzcl.service.RegularService;
import com.kcsj.wzcl.utils.Result;
import org.apache.naming.factory.ResourceLinkFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegularServiceImple implements RegularService {

    @Autowired
    private RegularMapper regularMapper;

    @Override
    public Result addOne(Regular regular) {
        RegularExample regularExample = new RegularExample();

        RegularExample.Criteria criteria = regularExample.createCriteria();
        String code = regular.getCode();
        criteria.andCodeLike(code + "%");
        List<Regular> regulars = regularMapper.selectByExample(regularExample);
        int temp = 0;
        if(regulars!=null) {
            for (Regular r : regulars) {

                String str = r.getCode().substring(code.length()+1);
                System.out.println(str);
                temp = temp < Integer.valueOf(str) ? Integer.valueOf(str) : temp;
                System.out.println(temp);
            }
        }
        temp++;
        regular.setCode(code + "-" + temp);
        int id = regularMapper.insert(regular);
        if (id <= 0) {
            return Result.Fail();
        }
        return Result.Success();
    }

    @Override
    public Result getAll() {
        List<Regular> regulars = regularMapper.selectByExample(null);
        return Result.add(regulars);
    }

    @Override
    public Result getById(int id) {
        Regular regular = regularMapper.selectByPrimaryKey(id);
        return Result.add(regular);
    }

    @Override
    public Result deleteById(int id) {
        int count = regularMapper.deleteByPrimaryKey(id);
        if (count != 0) {
            return Result.Success();
        } else {
            Result result = new Result();
            result.setDescription("删除失败 无此记录");
            result.setStatusCode(100);
            return result;
        }


    }
}
