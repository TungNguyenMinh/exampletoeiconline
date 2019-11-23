package com.minhtung.core.data.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericDao<ID extends Serializable, T> {
    List<T> findAll();

    T update(T entity);

    void save(T entity);

    T findById(ID id);

    Object findeByProperty(Map<String, Object> property, String sortExpession, String sortDirection, Integer offset, Integer limit);

    Integer delete(List<ID> ids);
}
