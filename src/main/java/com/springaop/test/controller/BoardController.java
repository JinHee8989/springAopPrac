package com.springaop.test.controller;

import com.springaop.test.model.vo.NoticeInfo;
import com.springaop.test.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api")
public class BoardController {

    @Autowired
    private BoardService boardService;

    /***********************
     * AOP테스트용 메소드
     ***********************/
    //    @LogExecutionTime
    @GetMapping(value = "/knock")
    public String getKnock(){

        String knock = "똑똑";
        System.out.println(knock + " 거기 누구 있나여");

        return knock;
    }

    /**************************
     * 공지사항 등록
     **************************/
    @PostMapping(value = "/register")
    public void writeNotice(NoticeInfo noticeInfo){
        System.out.println("noticeInfo = " + noticeInfo);
        boardService.setNotice(noticeInfo);
    }






}
