package com.xiaoke.system.dao;

import com.xiaoke.system.entity.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDAO extends BaseDao<Role,String> {

    @Query(value="select ro.* from user_role ur " +
            "left join role ro on ur.role_id = ro.id " +
            "where ur.uid = ?1 ",nativeQuery = true)
    List<Role> selectRoleAll(Long uid);
}
