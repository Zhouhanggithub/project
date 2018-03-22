package com.eny.dao;

import com.eny.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Created by MoMo on 2018/1/2.
 */
public interface UserDAO {
    User findByUserNameAndPassword(Map map) throws Exception;

    List getAllUsers() throws Exception;
}
