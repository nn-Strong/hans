package com.xiaoke.model.hans.qt.index.controller;

import com.xiaoke.model.hans.qt.index.model.Users;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

/**
 * Jpa正删改查实例
 *
 */
@RestController
public class DemoController {

    @Autowired
    private EntityManager entityManager;

    @RequiresRoles("admin")
    @RequestMapping("/gofr")
    public String demo(){
        Map map = new HashMap<>();
        map.put("name","welcom to freemarker!");
        String sql = "select * from users";
        Query query = entityManager.createNativeQuery(sql.toString(), Users.class);
        return "admin";
    }
    @RequiresRoles("ts")
    @RequestMapping("/gofr1")
    public String demo1(){
        Map map = new HashMap<>();
        map.put("name","welcom to freemarker!");
        String sql = "select * from users";
        Query query = entityManager.createNativeQuery(sql.toString(), Users.class);
        return "ts";
    }




}
