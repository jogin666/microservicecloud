package com.springcloud.client1.service.impl;

import com.springcloud.api.entity.Dept;
import com.springcloud.client1.dao.DeptDao;
import com.springcloud.client1.service.DeptService;
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
