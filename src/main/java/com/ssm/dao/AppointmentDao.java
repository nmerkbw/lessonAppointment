package com.ssm.dao;

import com.ssm.entity.Appointment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppointmentDao {

    /**
     * 通过课程ID和学生ID预约课程，并插入
     *
     * @param lessonId
     * @param studentId
     * @return
     * */
    int insertAppointment(@Param("lessonId") long lessonId, @Param("studentId") long studentId);

    /**
     * 通过一个学生ID查询已经预约了哪些课程。
     *
     * @param studentId
     * @return
     * */
    List<Appointment> quaryAndReturn(long studentId);
}
