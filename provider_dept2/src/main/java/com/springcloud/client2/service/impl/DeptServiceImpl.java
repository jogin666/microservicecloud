package com.springcloud.client2.service.impl;

import com.springcloud.client2.dao.DeptDao;
import com.springcloud.client2.service.DeptService;
import com.springcloud.api.entity.Dept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean saveDept(Dept dept) {
        return deptDao.saveDept(dept);
    }

    @Override
    public Dept findById(Long id) {
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> findAll() {
        return deptDao.findAll();
    }
}
