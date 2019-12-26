package com.springcloud.client;


import com.springcloud.api.entity.Dept;
import com.springcloud.client1.DeptProvider8001;
import com.springcloud.client1.dao.DeptDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = DeptProvider8001.class)
@RunWith(SpringRunner.class)
public class DeptProviderTest {

    @Autowired
    private DeptDao deptDao;

    @Test
    public void contextLoads() {

    }

    @Test
    public void findById(){

        Dept dept = deptDao.findById((long) 1);
        Assert.assertNotNull(dept);
        System.out.println(dept);
    }

}
