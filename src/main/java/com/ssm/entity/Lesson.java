package com.ssm.entity;

public class Lesson {

    // 课程ID
    private long lessonId;

    // 课程名称
    private String name;

    // 上课限制人数
    private int number;

    // 课程授课老师信息
    private String introd;

    public Lesson() {
    }

    public Lesson(long lessonId, String name, int number, String introd) {

        this.lessonId = lessonId;
        this.name = name;
        this.number = number;
        this.introd = introd;
    }

    public long getLessonId() {

        return lessonId;
    }

    public void setLessonId(long lessonId) {

        this.lessonId = lessonId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getNumber() {

        return number;
    }

    public void setNumber(int number) {

        this.number = number;
    }

    public String getIntrod() {

        return introd;
    }

    public void setIntrod(String introd) {

        this.introd = introd;
    }

    @Override
    public String toString() {

        return "Lesson{" +
                "lessonId=" + lessonId +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", introd='" + introd + '\'' +
                '}';
    }
}
