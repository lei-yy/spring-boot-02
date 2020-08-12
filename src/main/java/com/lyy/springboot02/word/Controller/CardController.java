package com.lyy.springboot02.word.Controller;

import com.github.pagehelper.PageInfo;
import com.lyy.springboot02.pojo.Result;
import com.lyy.springboot02.pojo.SearchVo;
import com.lyy.springboot02.word.pojo.Card;
import com.lyy.springboot02.word.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: spring-boot-02
 * @description
 * @author: lyy
 * @create: 2020-08-12 19:47
 **/
@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;

    //127.0.0.1/card/selectByPage
    @PostMapping("/selectByPage")
    public PageInfo<Card> selectByPage(@RequestBody SearchVo searchVo){
        return cardService.selectByPage(searchVo);
    }

    //127.0.0.1/card/insertByCard
    @PostMapping(value = "/insertByCard",consumes = "application/json")
    public Result<Card> insertByCard(@RequestBody Card card){
        return cardService.insertByCard(card);
    }

    //127.0.0.1/card/deleteByCardId
    @DeleteMapping("/deleteByCardId")
    public void deleteByCardId(@PathVariable int cardId){
        cardService.deleteByCardId(cardId);
    }

    //127.0.0.1/card/updateByCardId
    @PutMapping(value = "/updateByCardId",consumes = "application/x-www-form-urlencoded;charset=UTF-8")
    public Result<Card> updateByCardId(@RequestBody Card card){
        return cardService.updateByCardId(card);
    }

}
