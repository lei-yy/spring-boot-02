package com.lyy.springboot02.word.service.impl;

import com.github.pagehelper.PageInfo;
import com.lyy.springboot02.pojo.Result;
import com.lyy.springboot02.pojo.SearchVo;
import com.lyy.springboot02.word.pojo.Card;
import com.lyy.springboot02.word.repository.CardRepository;
import com.lyy.springboot02.word.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-12 19:44
 **/
@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;
    @Override
    public PageInfo<Card> selectByPage(SearchVo searchVo) {
        searchVo.initSearchVo();
        return new PageInfo<>(Optional.ofNullable(cardRepository.findAll()).orElse(Collections.emptyList()));
    }

    @Override
    @Transactional
    public Result<Card> insertByCard(Card card) {
        cardRepository.save(card);
        return new Result<Card>(Result.status.SUCCESS.status,"insert success",card);
    }

    @Override
    @Transactional
    public void deleteByCardId(int cardId) {
        cardRepository.deleteById(cardId);
    }

    @Override
    @Transactional
    public Result<Card> updateByCardId(Card card) {
        cardRepository.flush();
        return new Result<Card>(Result.status.SUCCESS.status,"update success",card);
    }
}
