package com.tao;

import com.tao.springaop.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: Penger
 * @time: 2019/3/28
 * @description: <p>
 * </p>
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AOPtest {

    @Autowired
    Person student;

    @Test
    public void testMyAop() {
        student.name("hello aop");
        System.out.println(student.getClass());
    }
}
