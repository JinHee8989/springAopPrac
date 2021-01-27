package com.springaop.test.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BoardController.class)
class BoardControllerTest {

    @Autowired  //스프링이 관리하는 Bean을 주입받음
    private MockMvc mvc;    // 웹API를 테스트할 때 사용, 스프링MVC테스트의 시작점임

    @Test
    void 노크테스트() throws Exception {

        mvc.perform(get("/knock"))
                .andExpect(status().isOk())
                .andExpect(content().string("똑똑"));
    }

}
