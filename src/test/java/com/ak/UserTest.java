package com.ak;

import org.junit.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;


public class UserTest {

    @Test
    public void testUserCreation() throws Exception
    {
        User user = new User("1","testName", "2016-04-15T05:19:46-10:00",true);
        assertThat(user.getId().equals("1"));
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 4,15);

        assertThat(user.getCreatedAt().equals(calendar.getTime()));
        System.out.println(user.toString());
    }

}