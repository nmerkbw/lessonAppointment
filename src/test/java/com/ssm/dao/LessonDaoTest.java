package com.ssm.dao;

import com.ssm.entity.Lesson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class LessonDaoTest {

    @Resource
    private LessonDao lessonDao;

    @Test
    public void queryById() throws Exception {

        long lessonId = 1001;
        Lesson lesson = lessonDao.queryById(lessonId);
        System.out.println(lesson);
    }

    @Test
    public void querySome() throws Exception {

        String name = "数据结构";
        List<Lesson> lessons = lessonDao.querySome(name);
        System.out.println(lessons);
    }

    @Test
    public void queryAll() throws Exception {

        List<Lesson> lessons = lessonDao.queryAll(0, 100);
        System.out.println(lessons);
    }

    @Test
    public void reduceNumber() throws Exception {

        long lessonId = 1001;
        int updateCount = lessonDao.reduceNumber(lessonId);
        System.out.println("updateCount: " + updateCount);
    }

}