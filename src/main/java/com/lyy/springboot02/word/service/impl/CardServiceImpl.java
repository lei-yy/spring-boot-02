package com.lyy.springboot02.word.service.impl;

import com.github.pagehelper.PageInfo;
import com.lyy.springboot02.pojo.Result;
import com.lyy.springboot02.pojo.SearchVo;
import com.lyy.springboot02.word.pojo.Card;
import com.lyy.springboot02.word.repository.CardRepository;
import com.lyy.springboot02.word.service.CardService;
import net.bytebuddy.description.type.TypeDefinition;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
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
    public Page<Card> selectByPage(SearchVo searchVo) {
        searchVo.initSearchVo();
        //确定排序方向
        Sort.Direction direction="desc".equalsIgnoreCase(searchVo.getSort())?
                Sort.Direction.DESC:Sort.Direction.ASC;
        //确定通过什么排序，如果没有就cardId排序
        Sort sort=new Sort(direction, StringUtils.isBlank(searchVo.getOrderBy())?
                "cardId":searchVo.getOrderBy());
        Card card=new Card();
        card.setCardNo(searchVo.getKeyWord());
        Pageable pageable= PageRequest.of(searchVo.getCurrentPage()-1,searchVo.getPageSize(),sort);
        ExampleMatcher matcher=ExampleMatcher.matching()
                .withMatcher("cardNo",match ->match.contains())
                .withIgnorePaths("cardId");
        Example<Card> example=Example.of(card,matcher);
        return cardRepository.findAll(example,pageable);
    }

    @Override
    @Transactional
    public Result<Card> insertByCard(Card card) {
        cardRepository.saveAndFlush(card);
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
        cardRepository.save(card);
        return new Result<Card>(Result.status.SUCCESS.status,"update success",card);
    }
}
