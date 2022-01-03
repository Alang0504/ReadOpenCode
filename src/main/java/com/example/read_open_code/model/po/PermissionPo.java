package com.example.read_open_code.model.po;

import lombok.Data;

import java.util.List;

@Data
public class PermissionPo {
    private Integer id;
    private String per_flag;
    private String per_name;
    private String res_name;
    private String res_url;
    private List<RolePo> rolePoList;
}
