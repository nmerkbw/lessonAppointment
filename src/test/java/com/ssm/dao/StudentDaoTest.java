package com.ssm.dao;

import com.ssm.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class StudentDaoTest {

    @Resource
    private StudentDao studentDao;

    @Test
    public void quaryStudent() throws Exception {

        long studentId = 201622021118L;
        long password = 123456;
        Student student = studentDao.quaryStudent(studentId, password);
        System.out.println(student);
    }

}