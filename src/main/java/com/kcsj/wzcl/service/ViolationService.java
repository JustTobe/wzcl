package com.kcsj.wzcl.service;

import com.kcsj.wzcl.bean.Violation;
import com.kcsj.wzcl.mapper.ViolationMapper;
import com.kcsj.wzcl.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
//import sun.security.mscapi.RSASignature;
import sun.security.provider.MD5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

@Service
public class ViolationService {
    @Autowired
    private ViolationMapper violationMapper;

    public Result add(Violation violation)
    {
        if(violationMapper.insert(violation)==0)
            return Result.Fail();
        return Result.Success();
    }

    public Result upload(MultipartFile file)
    {
        //存储文件名
        String fileName=System.currentTimeMillis()+file.getOriginalFilename();
        //存储路径
        String path="C:\\server\\pic";
        //MD5 hash=new MD5();
        //byte[] bytehashValue=hash
        File picPath=new File(path+File.separator+fileName);

        try{
            file.transferTo(picPath);

        }catch(IOException e)
        {
            e.printStackTrace();
            return Result.Fail();
        }

        Result result =new Result();
        result.setStatusCode(200);
        result.setData(fileName);
        return result;
    }
}
