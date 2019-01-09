package com.kcsj.wzcl.service;

import com.kcsj.wzcl.bean.Regular;
import com.kcsj.wzcl.utils.Result;

public interface   RegularService {
    Result addOne(Regular regular);

    Result getAll();

    Result getById(int id);

    Result deleteById(int id);
}
