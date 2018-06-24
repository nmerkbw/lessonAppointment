package com.ssm.service;

import com.ssm.dto.AppointExcution;
import com.ssm.entity.Appointment;
import com.ssm.entity.Lesson;
import com.ssm.entity.Student;

import java.util.List;

public interface LessonService {

    /**
     * 查询一门课程
     *
     * @param lessonId
     * @return
     */
    Lesson getById(long lessonId);

    /**
     * 查询所有课程
     *
     * @return
     */
    List<Lesson> getList();

    /**
     * 登陆时查询数据库是否有该学生记录。
     *
     * @param studentId
     * @param password
     * @return
     */
    Student validateStu(Long studentId, Long password);

    /**
     * 按照课程名称查询
     * 按条件搜索课程
     *
     * @param name
     * @return
     */
    List<Lesson> getSomeList(String name);

    /**
     * 查看某学生预约的所有课程
     * @param studentId
     * @return
     */
    List<Appointment> getAppointByStu(long studentId);

    /**
     * 预约课程
     *
     * @param lessonId
     * @param studentId
     * @return
     * 返回预约成功的实体类
     */
    AppointExcution appoint(long lessonId, long studentId);
}
