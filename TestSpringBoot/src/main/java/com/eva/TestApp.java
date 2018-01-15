package com.eva;

import com.eva.entity.User;
import com.eva.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

/**
 * Created by 01348085 on 2017/7/6.
 */
//@SpringBootApplication
public class TestApp implements CommandLineRunner{
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TestApp.class);
        app.setWebEnvironment(false);
        app.run(args);
    }
    @Override
    public void run(String... strings) throws Exception {
        User user = userService.findById(1L);
        System.out.println(user.getUserName());
    }
}
