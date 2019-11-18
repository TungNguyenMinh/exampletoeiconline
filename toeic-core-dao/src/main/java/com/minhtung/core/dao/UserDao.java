package com.minhtung.core.dao;

import com.minhtung.core.data.dao.GenericDao;
import com.minhtung.core.persistence.entity.UserEntity;

public interface UserDao extends GenericDao<Integer, UserEntity> {

    UserEntity findUserByUsernameAndPassword(String name, String password);
}
