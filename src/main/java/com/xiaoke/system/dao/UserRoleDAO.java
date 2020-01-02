package com.xiaoke.system.dao;

import com.xiaoke.system.entity.Permission;
import com.xiaoke.system.entity.UserRole;
import com.xiaoke.system.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleDAO extends JpaRepository<UserRole, Long> {





}
