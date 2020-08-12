package com.lyy.springboot02.word.service;

import com.github.pagehelper.PageInfo;
import com.lyy.springboot02.pojo.Result;
import com.lyy.springboot02.pojo.SearchVo;
import com.lyy.springboot02.word.pojo.Card;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-12 19:44
 **/
public interface CardService {
    PageInfo<Card> selectByPage(SearchVo searchVo);

    Result<Card> insertByCard(Card card);

    void deleteByCardId(int cardId);

    Result<Card> updateByCardId(Card card);
}
