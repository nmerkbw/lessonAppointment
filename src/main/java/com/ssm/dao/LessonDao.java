package com.ssm.dao;

import com.ssm.entity.Lesson;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LessonDao {

    /**
     * 根据id查询课程
     *
     * @param id
     * @return
     * */
    Lesson queryById(long id);

    /**
     * 根据课程名查询课程
     *
     * @param name
     * @return
     * */
    List<Lesson> querySome(String name);

    /**
     * 根据偏移量查询秒杀商品列表
     *
     * @param offset
     * @param limit
     * @return
     * @note queryAll方法为什么不直接查询所有记录，用offset和limit限制区间的好处是什么？
     * 为了分页显示用，如果全部查询所有记录的话，DB里的记录数特别多的话，影响性能。
     */
    List<Lesson> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 减少管存数量
     * 用返回值可判断当前选择课程的人数是否达到上限
     * 即初始化的人数，课程每被选一次，人数减1
     *
     * @param lessonId
     * @return
     * */
    int reduceNumber(long lessonId);
}
