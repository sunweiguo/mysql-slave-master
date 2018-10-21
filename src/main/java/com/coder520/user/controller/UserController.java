package com.coder520.user.controller;

import com.coder520.user.entity.User;
import com.coder520.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by JackWangon[www.aiprogram.top] 2017/6/16.
 */
@Controller
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserService userService;



    /**
     *@Description  获取用户信息
     */
    @RequestMapping("/getuser")
    @ResponseBody
    public User getUser(){
       return userService.findUserByUserId(1);
    }

    /**
     *@Description  新增一条用户信息
     */
    @RequestMapping("/setuser")
    @ResponseBody
    public int setUser(){
       return userService.insertUser();
    }



}
