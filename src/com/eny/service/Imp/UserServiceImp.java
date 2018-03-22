package com.eny.service.Imp;

import com.eny.dao.Impl.UserDaoImpl;
import com.eny.dao.UserDAO;
import com.eny.domain.User;
import com.eny.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MoMo on 2018/1/1.
 */
public class UserServiceImp implements UserService {
    private UserDAO userDao = new UserDaoImpl();

    @Override
    public User checkUser(String username, String password)  {
        Map map = new HashMap();
        User user = null;
        try {
            map.put("userName",username);
            map.put("passwd",password);
            user = userDao.findByUserNameAndPassword(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List getAllUsers(){
        List users = null;
        try {
            users = userDao.getAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
