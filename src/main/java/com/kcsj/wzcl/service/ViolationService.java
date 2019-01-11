package com.kcsj.wzcl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kcsj.wzcl.bean.ParamBody;
import com.kcsj.wzcl.bean.SearchParam;
import com.kcsj.wzcl.bean.Violation;
import com.kcsj.wzcl.bean.ViolationExample;
import com.kcsj.wzcl.mapper.ViolationMapper;
import com.kcsj.wzcl.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
//import sun.security.mscapi.RSASignature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ViolationService {
    @Autowired
    private ViolationMapper violationMapper;

    public Result searchByParam(Map<String, SearchParam> map, int page, int size) {
        ViolationExample violationExample = new ViolationExample();


        ViolationExample.Criteria criteria = violationExample.createCriteria();
        String[] str = {"plate", "date", "type", "area", "status"};
        String order = null;
        String s=null;
        for (int i=0;i<str.length;i++) {
            s=str[i];
            SearchParam param = map.get(s);
            System.out.println(s);
            if(param!=null){
            switch (s) {
                case "plate":
                    setOfLike(criteria, s, param);
                    break;
                case "area":
                    setOfLike(criteria, s, param);
                    break;
                case "date":
                    setOfScope(criteria, s, param);
                    break;
                default:
                    setOfIn(criteria, s, param);
                    break;
            }
            if (order == null) {
                order = s + " " + param.getOrder();
            } else {
                order += "," + s + " " + param.getOrder();
            }
            }
        }
        violationExample.setOrderByClause(order);
        PageHelper.startPage(page, size);
        List<Violation> list = violationMapper.selectByExample(violationExample);
        PageInfo<Violation> pageInfo = new PageInfo<>(list);
        if (pageInfo != null) {
            return Result.add(pageInfo);
        }
        return Result.Fail();
    }

    public void setOfLike(ViolationExample.Criteria criteria, String str, SearchParam searchParam) {
        List<ParamBody> paramBodyList = searchParam.getOperators();
        for (ParamBody paramBody : paramBodyList) {
            String keyword = paramBody.getKeyword();
            String matchType = paramBody.getMatchType();
            String key = keyword;
            switch (matchType) {
                case "BOTH":
                    key = "%" + keyword + "%";
                    break;

                case "LEFT":
                    key = "%" + keyword;
                    break;
                case "RIGHT":
                    key = keyword + "%";
                    break;
                default:
                    break;
            }
            if (str.equals("plate")) {
                criteria.andPlateLike(key);
            } else {
                criteria.andAreaLike(key);
            }
        }

    }

    public void setOfScope(ViolationExample.Criteria criteria, String str, SearchParam searchParam) {
        List<ParamBody> paramBodyList = searchParam.getOperators();
        for (ParamBody paramBody : paramBodyList) {
            String keyword = paramBody.getKeyword();
            String operator = paramBody.getOperator();
            long key = Long.valueOf(keyword);
            switch (operator) {
                case "GT":
                    criteria.andDateGreaterThan(key);
                    break;
                case "LT":
                    criteria.andDateLessThan(key);
                    break;
                case "GTE":
                    criteria.andDateGreaterThanOrEqualTo(key);
                    break;
                default:
                    criteria.andDateLessThanOrEqualTo(key);
                    break;
            }


        }

    }

    public void setOfIn(ViolationExample.Criteria criteria, String str, SearchParam searchParam) {
        List<ParamBody> paramBodyList = searchParam.getOperators();
        ParamBody paramBody = paramBodyList.get(0);
        String keyword = paramBody.getKeyword();
        String matchType = paramBody.getMatchType();
        String[] key = keyword.split(",");
        List<String> keyList = new ArrayList<>();
        for (int i = 0; i < key.length; i++) {
            keyList.add(key[i]);
        }
        switch (str) {
            case "type":
                criteria.andTypeIn(keyList);
                break;
            case "area":
                criteria.andAreaIn(keyList);
                break;
            case "status":
                criteria.andStatusIn(keyList);
                break;
            default:
                break;
        }


    }


    public Result add(Violation violation) {
        if (violationMapper.insert(violation) == 0)
            return Result.Fail();
        return Result.Success();
    }

    public Result upload(MultipartFile file) {
        //存储文件名
        String fileName = System.currentTimeMillis() + file.getOriginalFilename();
        //存储路径
        String path = "C:\\server\\pic";
        //MD5 hash=new MD5();
        //byte[] bytehashValue=hash
        File picPath = new File(path + File.separator + fileName);

        try {
            file.transferTo(picPath);

        } catch (IOException e) {
            e.printStackTrace();
            return Result.Fail();
        }

        Result result = new Result();
        result.setStatusCode(200);
        result.setData(fileName);
        return result;
    }


}
