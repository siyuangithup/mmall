package com.mmall.gateway.controller;

import com.mmall.gateway.common.ServerResponse;
import com.mmall.gateway.exception.MmallException;
import com.mmall.gateway.pojo.MmallUser;
import com.mmall.gateway.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Description
 * Create by dong.zhou
 * Date 2022/9/12 02:22
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/findById")
    public MmallUser findById(@RequestParam Integer id) {
        return userService.findById(id);
    }

    @PostMapping("/login")
    public ServerResponse<MmallUser> login(@RequestBody MmallUser mmallUser){

        log.info("登陆接口入参->{}", mmallUser);

        return userService.login(mmallUser.getUsername(), mmallUser.getPassword());

    }
}
