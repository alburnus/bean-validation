package com.github.alburnus.resource;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TeamResourceTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void whenNoData_thenReturnNotFound() throws Exception
    {
        mvc.perform(get("/teams"))
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("")));
    }

    //FIXME
    @Ignore
    @Test
    public void postTeam() throws Exception
    {
        mvc.perform(post("/teams")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1, \"name\": \"nazwa\"}"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}