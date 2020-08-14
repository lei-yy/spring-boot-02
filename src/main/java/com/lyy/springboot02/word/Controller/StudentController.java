package com.lyy.springboot02.word.Controller;

import com.lyy.springboot02.word.pojo.Student;
import com.lyy.springboot02.word.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-13 19:30
 **/
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //127.0.0.1/student/findByStudentName
    @RequestMapping("/findByStudentName")
    public List<Student>  findByStudentName(@RequestParam String studentName){
        return studentService.findByStudentName(studentName);
    }
    //127.0.0.1/student/findByStudentName
    @RequestMapping("/findByStudentNameLike")
    public List<Student>  findByStudentNameLike(@RequestParam String studentName){
        return studentService.findByStudentNameLike(studentName);
    }
    //127.0.0.1/student/findByStudentName
    @RequestMapping("/findTop2ByByStudentNameLike")
    public List<Student>  findTop2ByByStudentNameLike(@RequestParam String studentName){
        return studentService.findTop2ByByStudentNameLike(studentName);
    }
    //127.0.0.1/student/findByStudentName
    @RequestMapping("/getStudentsByParamsOne")
    public List<Student>  getStudentsByParamsOne(@RequestParam String studentName,@RequestParam int cardId){
        return studentService.getStudentsByParamsOne(studentName,cardId);
    }
    //127.0.0.1/student/findByStudentName
    @RequestMapping("/getStudentsByParamsTwo")
    public List<Student>  getStudentsByParamsTwo(@RequestParam String studentName,@RequestParam int cardId){
        return studentService.getStudentsByParamsTwo(studentName,cardId);
    }
}
