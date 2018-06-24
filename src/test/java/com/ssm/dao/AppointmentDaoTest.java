package com.ssm.dao;

import com.ssm.entity.Appointment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class AppointmentDaoTest {

    @Resource
    private AppointmentDao appointmentDao;
    @Test
    public void insertAppointment() throws Exception {

        long lessonId = 1001;
        long studentId = 201622021118L;
        int appointment = appointmentDao.insertAppointment(lessonId, studentId);
        System.out.println("appointment: " + appointment);
    }

    @Test
    public void quaryAndReturn() throws Exception {

        long studentId = 201622021118L;
        List<Appointment> appointments = appointmentDao.quaryAndReturn(studentId);
        System.out.println("==============================");
        System.out.println(appointments);
    }

}