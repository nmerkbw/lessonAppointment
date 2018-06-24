package com.ssm.web;

import com.ssm.dto.AppointExcution;
import com.ssm.dto.Result;
import com.ssm.entity.Appointment;
import com.ssm.entity.Lesson;
import com.ssm.entity.Student;
import com.ssm.enums.AppointStateEnum;
import com.ssm.exception.NumberFullException;
import com.ssm.exception.RepeatAppointException;
import com.ssm.service.LessonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/uestc/lesson")
public class LessonController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LessonService lessonService;

    /**
     * 获取课程列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)// todo get和post区别
    public String list(Model model) {

        List<Lesson> list = lessonService.getList();
        model.addAttribute("list", list);
        return "list";
    }

    /**
     * 搜索是否有所查询的课程
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(Model model,HttpServletRequest request)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        // 接收页面的值
        String name = request.getParameter("name");
        name = name.trim();
        // 向页面传值
        //model.addAttribute("name", name);
        List<Lesson> list = lessonService.getSomeList(name);
        model.addAttribute("list", list);
        return "list";
    }

    /**
     * 查看课程的详细情况
     */
    @RequestMapping(value = "/{lessonId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("lessonId") Long lessonId, Model model) {

        if (lessonId == null) {
            return "redirect:/uestc/lesson/list";
        }
        Lesson lesson = lessonService.getById(lessonId);
        if (lesson == null) {
            return "forward:/uestc/lesson/list";
        }
        model.addAttribute("lesson", lesson);
        System.out.println(lesson);
        return "detail";
    }

    /**
     * 验证输入的用户名、密码是否正确
     **/
    @RequestMapping(value = "/verify", method = RequestMethod.POST, produces =
            {"application/json; charset=utf-8"})
    @ResponseBody
    public Map validate(Long studentId, Long password) {

        Map resultMap = new HashMap();
        Student student = null;
        System.out.println("验证函数");
        student = lessonService.validateStu(studentId, password);

        System.out.println("输入的学号、密码：" + studentId + ":" + password);
        System.out.println("查询到的：" + student.getStudentId() + ":" + student.getPassword());

        if (student != null) {
            System.out.println("SUCCESS");
            resultMap.put("result", "SUCCESS");
            return resultMap;
        } else {
            resultMap.put("result", "FAILED");
            return resultMap;
        }
    }

    /**
     * 执行预约的逻辑
     */
    @RequestMapping(value = "/{lessonId}/appoint/{studentId}", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Result<AppointExcution> execute(@PathVariable("lessonId") Long lessonId, @PathVariable("studentId") Long studentId) {

        Result<AppointExcution> result = null;
        AppointExcution excution = null;

        try {
            excution = lessonService.appoint(lessonId, studentId);
            result = new Result<AppointExcution>(true, excution);
            return result;
        } catch (NumberFullException e1) {
            excution = new AppointExcution(lessonId, AppointStateEnum.NO_NUMBER);
            result = new Result<AppointExcution>(true, excution);
            return result;
        } catch (RepeatAppointException e2) {
            excution = new AppointExcution(lessonId, AppointStateEnum.REPEAT_APPOINT);
            result = new Result<AppointExcution>(true, excution);
            return result;
        } catch (Exception e) {
            excution = new AppointExcution(lessonId, AppointStateEnum.INNER_ERROR);
            result = new Result<AppointExcution>(true, excution);
            return result;
        }
    }

    @RequestMapping(value = "/appoint")
    public String appointLessons(@RequestParam("studentId") long studentId, Model model) {

        List<Appointment> appointList = new ArrayList<>();
        appointList = lessonService.getAppointByStu(studentId);
        model.addAttribute("appointList", appointList);

        return "appointLessonList";
    }
}
