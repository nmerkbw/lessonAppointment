package com.ssm.dto;

import com.ssm.enums.AppointStateEnum;

public class AppointExcution {

    // 课程ID
    private long lessonId;

    // 预约结果状态
    private int state;

    // 状态标识
    private String stateInfo;

    public AppointExcution() {
    }

    // 预约状态构造器
    public AppointExcution(long lessonId, AppointStateEnum stateEnum) {

        this.lessonId = lessonId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public long getLessonId() {

        return lessonId;
    }

    public void setLessonId(long lessonId) {

        this.lessonId = lessonId;
    }

    public int getState() {

        return state;
    }

    public void setState(int state) {

        this.state = state;
    }

    public String getStateInfo() {

        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {

        this.stateInfo = stateInfo;
    }

    @Override
    public String toString() {

        return "AppointExcution{" +
                "lessonId=" + lessonId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                '}';
    }
}
