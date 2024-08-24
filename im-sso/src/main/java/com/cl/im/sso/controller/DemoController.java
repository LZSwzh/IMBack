package com.cl.im.sso.controller;

import com.cl.im.sso.domain.entity.UserInfo;
import com.cl.im.sso.service.UserService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);
    @Autowired
    private UserService  userService;

    @GetMapping("/getOne/{id}")
    public UserInfo getOne(
            @PathVariable("id") Long id){
        log.info("输出日志");
        UserInfo userServiceById = userService.getById(id);
        return userServiceById;
    }

}
