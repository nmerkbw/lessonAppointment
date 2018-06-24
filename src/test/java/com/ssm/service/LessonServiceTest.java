package com.ssm.service;

import com.ssm.dto.AppointExcution;
import com.ssm.entity.Appointment;
import com.ssm.entity.Lesson;
import com.ssm.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class LessonServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LessonService lessonService;

    @Test
    public void getById() throws Exception {

        long lessonId = 1008;
        Lesson lesson = lessonService.getById(lessonId);
        logger.info("lesson={}", lesson);
    }

    @Test
    public void getList() throws Exception {

        List<Lesson> lessons = lessonService.getList();
        logger.info("list={}", lessons);
    }

    @Test
    public void validateStu() throws Exception {

        long studentId  = 201622021118L;
        long password = 123456;
        Student student = lessonService.validateStu(studentId, password);
        logger.info("student={}",student);
    }

    @Test
    public void getSomeList() throws Exception {

        String name = "数据结构";
        List<Lesson> someList = lessonService.getSomeList(name);
        logger.info("list={}", someList);
    }

    @Test
    public void getAppointByStu() throws Exception {

        long studentId = 201622021118L;
        List<Appointment> appointments = lessonService.getAppointByStu(studentId);
        logger.info("list={}", appointments);
    }

    @Test
    public void appoint() throws Exception {

        long lessonId = 1020;
        long studentId = 201622021118L;
        AppointExcution appoint = lessonService.appoint(lessonId, studentId);
        logger.info("appoint={}", appoint);
    }

}