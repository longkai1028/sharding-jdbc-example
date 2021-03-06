package com.shardingjdbc.web;


import com.shardingjdbc.entity.User;
import com.shardingjdbc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/selectLikePwd")
    public List<User> selectLikePwd(@RequestParam String pwd) {
        return userService.selectLikePwd(pwd);
    }


    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }

    @GetMapping("/add")
    public String add() {
        for (int i = 11; i < 20; i++) {
            User user = new User();
            user.setUserId(i);
            user.setUserName("yb" + (i));
            user.setPwd("123456pwd");
            user.setAssistedQueryPwd("AssistedQueryPwd");
            user.setUserNamePlain("杨滨");
            long resutl = userService.addUser(user);
            log.info("insert:" + user.toString() + " result:" + resutl);
        }
        return "ok";
    }
}
