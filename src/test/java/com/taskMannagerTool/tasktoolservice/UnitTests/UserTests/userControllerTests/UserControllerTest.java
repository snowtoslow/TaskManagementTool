package com.taskMannagerTool.tasktoolservice.UnitTests.UserTests.userControllerTests;


import com.taskMannagerTool.tasktoolservice.service.serviceImpl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;


    @MockBean
    private UserServiceImpl userServiceImpl;

    @Test
    private void getUsers() throws Exception{

    }


}
