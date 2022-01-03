package com.example.read_open_code.dao;

import com.example.read_open_code.model.po.PermissionPo;
import com.example.read_open_code.model.po.RolePo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDao {
    /**
     * 查询用户权限
     * @param rolePoList
     * @return
     */
    public List<PermissionPo> getUserPermissionsByRoleid(List<RolePo> rolePoList);
}
