package com.minhtung.core.data.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<ID extends Serializable, T> {
    List<T> findAll();
    T update (T entity);
    void save (T entity);
    T findById(ID id);
    Object findeByProperty (String property, Object value, String sortExpession, String sortDirection);
    Integer delete(List <ID> ids);
}
