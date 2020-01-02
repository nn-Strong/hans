package com.xiaoke.system.dao;

import com.xiaoke.system.entity.Permission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDAO  extends BaseDao<Permission,String>{
    @Query(value="SELECT\n" +
            "\tper.* \n" +
            "FROM\n" +
            "\trole_permission rp\n" +
            "\tLEFT JOIN user_role ur ON rp.role_id = ur.role_id\n" +
            "\tLEFT JOIN permission per ON per.id = rp.permission_id \n" +
            "WHERE\n" +
            "\tur.uid = ?1",nativeQuery = true)
    List<Permission> selectPerAll(Long uid);
}
