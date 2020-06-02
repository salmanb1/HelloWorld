package com.example.demo;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import com.example.demo.web.HomeController;

/*
This @WebMvcTest annotation arranges for the test to run in the context of a Spring MVC application
More specifically, in this case, it arranges for HomeController to be registered in Spring MVC so that you can throw
requests against it
 */
@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc; // This object mocks the mechanics of Spring MVC

    /*
    Your test will perform an HTTP GET request for the root path / and expect a successful result where the view name
    is 'home' and the resulting content contains the phrase “Welcome to...”.
     */
    @Test
    public void testHomePage () throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isOk()) // HTTP 200 OK status
                .andExpect(view().name("home"))
                .andExpect(content().string(             containsString("Welcome to")));
    }


}
