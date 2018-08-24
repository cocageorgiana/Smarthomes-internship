package com.example.smarthomes.register.testing;

import com.example.smarthomes.register.boundry.controller.RegisterController;
import com.example.smarthomes.register.entity.model.User;
import com.example.smarthomes.register.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(RegisterController.class)
public class RegisterControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void saveUserTest() throws Exception {
        given(userService.saveUser(new User("Test", "Test", "test.test", "test.test@gmail.com", "Ts@123456")))
                .willReturn(String.valueOf(new User("Test", "Test", "test.test", "test.test@gmail.com", "Ts@123456")));

        mockMvc.perform(post("/register")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}