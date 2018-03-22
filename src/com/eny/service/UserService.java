package com.eny.service;

import com.eny.domain.User;

import java.util.List;

/**
 * Created by MoMo on 2018/1/1.
 */
public interface UserService {
    /**
     *      检查用户是否存在
     * @param username  用户名
     * @param password  密码
     * @return  用户实体类
     */
    User checkUser(String username, String password);

    List getAllUsers();
}
