package com.xiaoke.system.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID extends Serializable> {
    T save(T var1);

    List<T> insertBatch(List<T> var1);

    void delete(ID var1);

    void deleteBatch(List<ID> var1);

    T update(T var1);

    Optional<T> getObjectByPK(ID var1);

    List<T> queryList(T var1);

    List<T> queryAll();

    Object queryListPage(Integer var1, Integer var2, T var3);

    Long queryTotal(Example<T> var1);

    Optional<T> findByT(T var1);

    List<T> queryList(T var1, Sort var2);

    List<T> queryAll(Sort var1);

    Object queryListPage(Integer var1, Integer var2, T var3, Sort var4);
}
