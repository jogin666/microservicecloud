package com.springcloud.client1.dao;

import com.springcloud.api.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {

    boolean saveDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
