package com.coder520.user.service;

import com.coder520.user.entity.User;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by JackWangon[www.aiprogram.top] 2017/6/16.
 */
public interface UserService {



    void createUser(User user) ;

    User findUserByUserId(long i);

    int insertUser();
}
