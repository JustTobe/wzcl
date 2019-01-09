package com.kcsj.wzcl.service;

import com.kcsj.wzcl.utils.Result;

public interface MessageService {
    Result getById(int id);

    Result getAll(int page, int size);
}
