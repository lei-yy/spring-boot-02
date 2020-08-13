package com.lyy.springboot02.word.service.impl;

import com.lyy.springboot02.word.pojo.Student;
import com.lyy.springboot02.word.repository.StudentRepository;
import com.lyy.springboot02.word.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-13 19:28
 **/
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> findByStudentName(String studentName) {
        return Optional
                .ofNullable(studentRepository.findByStudentName(studentName))
                .orElse(Collections.emptyList());
    }

    @Override
    public List<Student> findByStudentNameLike(String studentName) {
        return Optional
                .ofNullable(studentRepository.findByStudentNameLike(
                        String.format("%s%S%s", "%", studentName, "%")))
                .orElse(Collections.emptyList());
    }

    @Override
    public List<Student> findTop2ByByStudentNameLike(String studentName) {
        return Optional
                .ofNullable(studentRepository.findTop2ByStudentNameLike(
                        String.format("%s%S%s", "%", studentName, "%")))
                .orElse(Collections.emptyList());
    }

    @Override
    public List<Student> getStudentsByParamsOne(String studentName, int cardId) {
        return studentRepository.getStudentsByParamsOne(studentName,cardId);
    }

    @Override
    public List<Student> getStudentsByParamsTwo(String studentName, int cardId) {
        return studentRepository.getStudentsByParamsTwo(studentName,cardId);
    }
}
