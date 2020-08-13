package com.lyy.springboot02.word.service;

import com.lyy.springboot02.word.pojo.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-13 19:26
 **/
public interface StudentService {
    List<Student> findByStudentName(String studentName);
    List<Student> findByStudentNameLike(String studentName);
    List<Student> findTop2ByByStudentNameLike(String studentName);
    List<Student> getStudentsByParamsOne(String studentName,int cardId);
    List<Student> getStudentsByParamsTwo( String studentName,  int cardId);
}
