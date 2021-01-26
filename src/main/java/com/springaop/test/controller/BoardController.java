package com.springaop.test.controller;

import com.springaop.test.aspect.LogExecutionTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api")
public class BoardController {

//    @LogExecutionTime
    @GetMapping(value = "/knock")
    public String getKnock(){

        String knock = "똑똑";
        System.out.println("knock = " + knock);

        return knock;
    }


}
