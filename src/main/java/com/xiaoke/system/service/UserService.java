package com.xiaoke.system.service;

import com.xiaoke.system.dao.*;
import com.xiaoke.system.entity.Permission;
import com.xiaoke.system.entity.Role;
import com.xiaoke.system.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRoleDAO userRoleDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private RoleDAO roleDAO;
    @Autowired
    private PermissionDAO permissionDAO;
    @Autowired
    private RolePermissionDAO rolePermissionDAO;
    //根据用户id查询所有的角色信息
    public List<Role> findRoles(Long id) {
        List<Role> roles = roleDAO.selectRoleAll(id);
        return roles;
    }
    //根据用户的id查询所有权限信息
    public List<Permission> findPermissions(Long id) {
        List<Permission> permissionsList = permissionDAO.selectPerAll(id);
        return permissionsList;
    }

    public User findUserById(String uId) {
        List<User> user = userDAO.findByName(uId);
        User resUser = new User();
        if(user.size()>0) resUser = user.get(0);
        return resUser;
    }

    //分配默认用户权限 暂不处理
    @Transactional
    public int assignDefaultUserRolePermission(User user) {
        /*int success1 = userDAO.insert(user);
        UserRoleKey userRoleKey = new UserRoleKey();
        userRoleKey.setUid(user.getId());
        userRoleKey.setRoleId(2);
        int success2 = userRoleDAO.insert(userRoleKey);*/
//        return success1 + success2;

        return 0;

    }

}
