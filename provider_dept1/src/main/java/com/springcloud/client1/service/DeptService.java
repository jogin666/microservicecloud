package com.springcloud.client1.service;

import com.springcloud.api.entity.Dept;

import java.util.List;

public interface DeptService {

    boolean saveDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
