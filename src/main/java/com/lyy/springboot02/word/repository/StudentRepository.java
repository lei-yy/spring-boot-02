package com.lyy.springboot02.word.repository;


import com.lyy.springboot02.word.pojo.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-13 15:24
 **/
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findByStudentName(String studentName);
    List<Student> findByStudentNameLike(String studentName);
    List<Student> findTop2ByStudentNameLike(String studentName);

    @Query("select s from Student  s where s.studentName=?1 and s.studentCard.cardId=?2")
    List<Student> getStudentsByParamsOne(String studentName,int cardId);

    @Query(value="select s from Student  s where s.studentName=:studentName and s.studentCard.cardId=:cardId")
    List<Student> getStudentsByParamsTwo(@Param("studentName") String studentName, @Param("cardId") int cardId);
}
