package com.example.read_open_code.dao;

import com.example.read_open_code.model.po.UserPo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    /**
     * 查询用户
     * @param username
     * @return
     */
    public UserPo getUserByUsername(String username);
}
