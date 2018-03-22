package com.eny.dao.Impl;

import com.eny.dao.GenericDAO;
import com.eny.dao.UserDAO;
import com.eny.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Created by MoMo on 2018/1/2.
 */
public class UserDaoImpl implements UserDAO {
    private GenericDAO baseDao = new GenericDaoImpl();

    @Override
    public User findByUserNameAndPassword(Map userNameAndPasswordMap) throws Exception {
        String sql = "select * from t_user";
        List<User> users = baseDao.generalSelectSQL(sql, User.class, userNameAndPasswordMap);
        return users == null || users.size() ==0  ? null : users.get(0);
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        String sql = "select * from t_user";
        return baseDao.generalSelectSQL(sql,User.class);
    }
}
