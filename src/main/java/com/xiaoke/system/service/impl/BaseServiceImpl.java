package com.xiaoke.system.service.impl;

import com.xiaoke.system.dao.BaseDao;
import com.xiaoke.system.entity.BaseEntity;
import com.xiaoke.system.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public abstract class BaseServiceImpl<T extends BaseEntity, ID extends Serializable> implements BaseService<T, ID> {
    @Autowired
    BaseDao<T, ID> baseDao;
    @PersistenceContext
    private EntityManager entityManager;

    public BaseServiceImpl() {
    }

    public List<T> insertBatch(List<T> list) {
        return this.baseDao.saveAll(list);
    }

    public void delete(ID id) {
        this.baseDao.deleteById(id);
    }

    public T update(T t) {
        return this.save(t);
    }

    public Optional<T> getObjectByPK(ID id) {
        return this.baseDao.findById(id);
    }

    public Long queryTotal(Example<T> example) {
        return this.baseDao.count();
    }

    public List<T> queryList(T t) {
        Example<T> e = Example.of(t);
        return this.baseDao.findAll(e);
    }

    public Page<T> queryListPage(Integer pageNum, Integer pageSize, T t) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<T> e = Example.of(t, matcher);
        Page<T> page = this.baseDao.findAll(e, pageable);
        return page;
    }

    public List<T> queryAll() {
        return this.baseDao.findAll();
    }

    public T save(T t) {
        return (T) this.baseDao.save(t);
    }

    public void deleteBatch(List<ID> ids) {
        Iterator<ID> var2 = ids.iterator();

        while(var2.hasNext()) {
            ID id = var2.next();
            this.delete(id);
        }

    }

    public Page<T> queryListPage(Integer pageNum, Integer pageSize, T t, Sort sort) {
        //2.1版本将new PageRequest改为了PageRequest.of
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<T> e = Example.of(t, matcher);
        Page<T> page = this.baseDao.findAll(e, pageable);
        return page;
    }

    public List<T> queryList(T t, Sort sort) {
        Example<T> e = Example.of(t);
        return this.baseDao.findAll(e, sort);
    }

    public List<T> queryAll(Sort sort) {
        return this.baseDao.findAll(sort);
    }

    public Optional<T> findByT(T t) {
        Example<T> e = Example.of(t);
        Optional<T> tt = this.baseDao.findOne(e);
        return tt;
    }
}
