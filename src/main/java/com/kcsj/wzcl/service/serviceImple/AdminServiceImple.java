package com.kcsj.wzcl.service.serviceImple;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kcsj.wzcl.bean.Admin;
import com.kcsj.wzcl.bean.AdminExample;
import com.kcsj.wzcl.mapper.AdminMapper;
import com.kcsj.wzcl.service.AdminService;
import com.kcsj.wzcl.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImple implements AdminService {

    @Autowired
    private AdminMapper mapper;

    @Override
    public Result getByType(String type,int page, int size) {
        AdminExample example =new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andTypeLike("%"+type+"%");
        PageHelper.startPage(page,size);
        List<Admin> list = mapper.selectByExample(example);
        for(Admin admin : list){
            offPassword(admin);
        }
        PageInfo<Admin> pageInfo = new PageInfo<>(list);

        return Result.add(pageInfo);
    }

    @Override
    public Result getAll(int page, int size) {
        PageHelper.startPage(page,size);
        List<Admin> list = mapper.selectByExample(null);
        for(Admin admin : list){
            offPassword(admin);
        }
        PageInfo<Admin> pageInfo = new PageInfo<>(list);

        return Result.add(pageInfo);

    }

    @Override
    public Admin getById(String username) {
        Admin admin = mapper.selectByPrimaryKey(username);

        return admin;
    }

    public void offPassword(Admin admin){
        admin.setPassword("");
    }
}
