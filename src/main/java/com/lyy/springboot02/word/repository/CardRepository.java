package com.lyy.springboot02.word.repository;

import com.lyy.springboot02.word.pojo.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-12 19:41
 **/
@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
}
