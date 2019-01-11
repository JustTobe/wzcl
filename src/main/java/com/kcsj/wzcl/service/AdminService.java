package com.kcsj.wzcl.service;

import com.kcsj.wzcl.bean.Admin;
import com.kcsj.wzcl.utils.Result;

import java.util.List;

public interface AdminService {
    Result getByType(String type , int page, int size);
    Result getAll(int page, int size);
    Admin getById(String username);
    void offPassword(Admin admin);
}
