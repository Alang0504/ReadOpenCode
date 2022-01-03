package com.example.read_open_code.model.po;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class RolePo {
    private Integer id;
    private String name;
    private Date createtime;
    private List<PermissionPo> permissionPoList;
}
