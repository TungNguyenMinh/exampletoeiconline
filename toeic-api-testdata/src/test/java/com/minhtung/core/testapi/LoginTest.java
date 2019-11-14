package com.minhtung.core.testapi;

import com.minhtung.core.dao.UserDao;
import com.minhtung.core.daoimpl.UserDaoImpl;
import com.minhtung.core.persistence.entity.UserEntity;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class LoginTest {
    private final Logger log = Logger.getLogger(this.getClass());

    @Test
    public void checkIsUserExist() {
        UserDao userDao = new UserDaoImpl();
        String name = "minhtung";
        String password = "123456";
        UserEntity entity = userDao.isUserExist(name, password);
        if (entity != null) {
            log.error("login sucsess");
        } else {
            log.error("login fail");
        }
    }

    @Test
    public void checkFindRoleByUser() {
        UserDao userDao = new UserDaoImpl();
        String name = "minhtung";
        String password = "123456";
        UserEntity entity = userDao.findRoleByUser(name, password);
        log.error(entity.getRoleEntity().getRoleId() + "-" + entity.getRoleEntity().getName());
    }
}
