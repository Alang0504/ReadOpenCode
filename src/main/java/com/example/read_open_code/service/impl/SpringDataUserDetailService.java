package com.example.read_open_code.service.impl;

import com.example.read_open_code.dao.PermissionDao;
import com.example.read_open_code.dao.RoleDao;
import com.example.read_open_code.dao.UserDao;
import com.example.read_open_code.model.po.PermissionPo;
import com.example.read_open_code.model.po.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 认证，前端提交的用户名和密码交由spring security去验证，定义用户信息服务(查询用户信息)
 * 通过数据库方式根据账号查询用户
 */
@Service
public class SpringDataUserDetailService implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        /* 参数s：为接收到的用户名username
         * 根据username查询数据库*/
        UserPo user = userDao.getUserByUsername(s);
        if (user==null){
            // 如果查不到用户，返回null，由provider来抛出异常
            return null;
        }
        // 查询用户权限
        List<PermissionPo> permissions = permissionDao.getUserPermissionsByRoleid(user.getRolePoList());
        // 将permissions转成数组
        String[] permissionArray = permissions.toArray(new String[permissions.size()]);
        // 定义用户信息
        UserDetails userDetails = User.withUsername(user.getLoginid()).password(user.getPassword()).authorities(permissionArray).build();
        return userDetails;
    }
}
