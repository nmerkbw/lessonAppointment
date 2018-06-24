package com.ssm.service.impl;

import com.ssm.dao.AppointmentDao;
import com.ssm.dao.LessonDao;
import com.ssm.dao.StudentDao;
import com.ssm.dto.AppointExcution;
import com.ssm.entity.Appointment;
import com.ssm.entity.Lesson;
import com.ssm.entity.Student;
import com.ssm.enums.AppointStateEnum;
import com.ssm.exception.AppoinException;
import com.ssm.exception.NumberFullException;
import com.ssm.exception.RepeatAppointException;
import com.ssm.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired(required = false)
    private LessonDao lessonDao;

    @Autowired(required = false)
    private AppointmentDao appointmentDao;

    @Autowired(required = false)
    private StudentDao studentDao;

    @Override
    public Lesson getById(long lessonId) {

        return lessonDao.queryById(lessonId);
    }

    @Override
    public List<Lesson> getList() {

        return lessonDao.queryAll(0, 1000);// todo 分页
    }

    @Override
    public Student validateStu(Long studentId, Long password) {

        return studentDao.quaryStudent(studentId, password);
    }

    @Override
    public List<Lesson> getSomeList(String name) {

        return lessonDao.querySome(name);
    }

    @Override
    public List<Appointment> getAppointByStu(long studentId) {//DOTO

        return appointmentDao.quaryAndReturn(studentId);
    }

    @Override
    @Transactional
    /**
     * 使用注解控制事务方法的优点:
     * 1.开发团队达成一致约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作RPC/HTTP请求或者剥离到事务方法外部
     * 3.不是所有的方法都需要事务，如只有一条修改操作、只读操作不要事务控制
     */
    // //在Dao的基础上组织逻辑，形成与web成交互用的方法
    public AppointExcution appoint(long lessonId, long studentId) {

        try {
            int update = lessonDao.reduceNumber(lessonId);// 减少课程可选的人数
            // 课程人数已经满了（每有一个人选课，人数减1，当剩余为0时，课程选满）
            if (update <= 0) {
                throw new NumberFullException("number is full");
            } else {
                // 执行预约操作
                int insert = appointmentDao.insertAppointment(lessonId, studentId);
                // 重复预约
                if (insert <= 0) {
                    throw new RepeatAppointException("repeat appoint");
                } else {
                    // 预约成功
                    return new AppointExcution(lessonId, AppointStateEnum.SUCCESS);
                }
            }
        } catch (NumberFullException e1) {
            throw e1;
        } catch (RepeatAppointException e2) {
            throw e2;
        } catch (Exception e) {
            // 将所有编译期异常转为运行时异常
            throw new AppoinException("lesson inner error: " + e.getMessage());
        }
    }
}
