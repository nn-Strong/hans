package com.xiaoke.config.shiro;

import com.xiaoke.system.entity.Permission;
import com.xiaoke.system.entity.Role;
import com.xiaoke.system.entity.User;
import com.xiaoke.system.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    //shiro的权限信息配置  每次调用权限注解的时候才查权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String uid = (String) principals.getPrimaryPrincipal();
        List<Role> roles = userService.findRoles(Long.parseLong(uid));
        Set<String> roleNames = new HashSet<>(roles.size());
        for (Role role : roles) {
            roleNames.add(role.getRole());
        }
        //此处把当前subject对应的所有角色信息交给shiro，调用hasRole的时候就根据这些role信息判断
        authorizationInfo.setRoles(roleNames);
        List<Permission> permissions = userService.findPermissions(Long.parseLong(uid));
        Set<String> permissionNames = new HashSet<>(permissions.size());
        for (Permission permission : permissions) {
            permissionNames.add(permission.getName());
        }
        //此处把当前subject对应的权限信息交给shiro，当调用hasPermission的时候就会根据这些信息判断
        authorizationInfo.setStringPermissions(permissionNames);
        return authorizationInfo;
    }

    //根据token获取认证信息authenticationInfo
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String uId = (String) token.getPrincipal();
        if(uId == null){
            return null;
        }
        User user = userService.findUserById(uId);
        if (user == null) {
            return null;
        }
        //SimpleAuthenticationInfo还有其他构造方法，比如密码加密算法等，感兴趣可以自己看
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                uId,                      //表示凭证，可以随便设，跟token里的一致就行
                user.getEmail(),   //表示密钥如密码，你可以自己随便设，跟token里的一致就行
                getName()
        );
        //authenticationInfo信息交个shiro，调用login的时候会自动比较这里的token和authenticationInfo
        return authenticationInfo;
    }

}
