package com.xiaoke.system.dao;

import com.xiaoke.system.entity.User;
import org.springframework.stereotype.Repository;

import java.nio.file.OpenOption;
import java.util.List;

@Repository
public interface UserDAO extends BaseDao<User,Long> {

    List<User> findByName(String name);

}
