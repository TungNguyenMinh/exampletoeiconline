package com.minhtung.core.daoimpl;

import com.minhtung.core.dao.UserDao;
import com.minhtung.core.data.daoimpl.AbstractDao;
import com.minhtung.core.persistence.entity.UserEntity;
import com.minhtung.core.web.common.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class UserDaoImpl extends AbstractDao<Integer, UserEntity> implements UserDao {

    public UserEntity findUserByUsernameAndPassword(String name, String password) {
        UserEntity entity = new UserEntity();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder sql = new StringBuilder("FROM UserEntity WHERE name= :name AND password= :password");
            Query query = session.createQuery(sql.toString());
            query.setParameter("name", name);
            query.setParameter("password", password);
            entity = (UserEntity) query.uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return entity;
    }
}
