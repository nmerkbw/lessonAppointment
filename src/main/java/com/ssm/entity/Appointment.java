package com.ssm.entity;

import java.util.Date;

public class Appointment {

    private long lessonId;

    private long studentId;

    private Date appointTime;

    // 课程实体，多对一的复合属性
    private Lesson lesson;

    public Appointment() {
    }

    public Appointment(long lessonId, long studentId, Date appointTime, Lesson lesson) {

        this.lessonId = lessonId;
        this.studentId = studentId;
        this.appointTime = appointTime;
        this.lesson = lesson;
    }

    public long getLessonId() {

        return lessonId;
    }

    public void setLessonId(long lessonId) {

        this.lessonId = lessonId;
    }

    public long getStudentId() {

        return studentId;
    }

    public void setStudentId(long studentId) {

        this.studentId = studentId;
    }

    public Date getAppointTime() {

        return appointTime;
    }

    public void setAppointTime(Date appointTime) {

        this.appointTime = appointTime;
    }

    public Lesson getLesson() {

        return lesson;
    }

    public void setLesson(Lesson lesson) {

        this.lesson = lesson;
    }

    @Override
    public String toString() {

        return "Appointment{" +
                "lessonId=" + lessonId +
                ", studentId=" + studentId +
                ", appointTime=" + appointTime +
                ", lesson=" + lesson +
                '}';
    }
}
