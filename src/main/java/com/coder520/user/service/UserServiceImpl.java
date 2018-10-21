package com.coder520.user.service;

import com.coder520.common.DataSource;
import com.coder520.common.DataSourceType;
import com.coder520.common.DynamicDataSourceHolder;
import com.coder520.user.dao.UserMapper;
import com.coder520.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by JackWangon[www.aiprogram.top] 2017/6/16.
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;


    /**
     *@Author JackWang [www.coder520.com]
     *@Date 2017/6/18 12:48
     *@Description 根据用户名查询用户
     */
    @DataSource(DataSourceType.SLAVE)
    @Override
    public User findUserByUserId(long id) {
        User user=null;
        try {
             user =userMapper.selectByPrimaryKey(id);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        return user;
    }

    @Override
    @Transactional
    public int insertUser() {
        User user = new User();
        user.setMobile("1234567");
        user.setNickname("laowang");
        User user1 = new User();
        user1.setId(2L);
        user1.setMobile("11111111");
        user1.setNickname("laowang2");
         userMapper.insertSelective(user);
         userMapper.insertSelective(user1);
         return 0;
    }


    @Override
    public void createUser(User user) {
        userMapper.insertSelective(user);
    }
}
