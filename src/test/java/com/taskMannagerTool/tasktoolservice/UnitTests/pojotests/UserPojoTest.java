package com.taskMannagerTool.tasktoolservice.UnitTests.pojotests;

import com.taskMannagerTool.tasktoolservice.models.User;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.Assert.assertThat;

public class UserPojoTest {

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Test
    public void create(){
        User user = new User();

        user.setName("Jane");
        user.setSurname("Turner");
        user.setUsername("janeTurner");
        user.setUserEmail("jane.turner@gmail.com");
        user.setSpeciality("Tester");
        user.setUserPassword("123456789");



        Assert.assertEquals(user.getName(),"Jane");
        assertThat(user.getName(), Matchers.equalToIgnoringCase("Jane"));

        Assert.assertEquals(user.getSurname(),"Turner");
        assertThat(user.getSurname(), Matchers.equalToIgnoringCase("Turner"));

        Assert.assertEquals(user.getUsername(),"janeTurner");
        assertThat(user.getUsername(), Matchers.equalToIgnoringCase("janeTurner"));

        Assert.assertEquals(user.getUserEmail(),"jane.turner@gmail.com");
        assertThat(user.getUserEmail(), Matchers.equalToIgnoringCase("jane.turner@gmail.com"));

        Assert.assertEquals(user.getSpeciality(),"Tester");
        assertThat(user.getSpeciality(), Matchers.equalToIgnoringCase("Tester"));

        Assert.assertEquals(user.getUserPassword(),"123456789");
        assertThat(user.getUserPassword(), Matchers.equalToIgnoringCase("123456789"));


    }

}
