package com.minhtung.core.service.impl;

import com.minhtun.core.utils.UserBeanUtil;
import com.minhtung.core.dao.UserDao;
import com.minhtung.core.daoimpl.UserDaoImpl;
import com.minhtung.core.dto.UserDTO;
import com.minhtung.core.persistence.entity.UserEntity;
import com.minhtung.core.service.UserService;

public class UserServiceImpl implements UserService {

    public UserDTO isUserExitst(UserDTO dto) {
        UserDao userDao = new UserDaoImpl();
        UserEntity entity = userDao.isUserExist(dto.getName(), dto.getPassword());
        return UserBeanUtil.entity2Dto(entity);
    }

    public UserDTO findRoleByUser(UserDTO dto) {
        UserDao userDao = new UserDaoImpl();
        UserEntity entity = userDao.findRoleByUser(dto.getName(), dto.getPassword());
        return UserBeanUtil.entity2Dto(entity);
    }
}
