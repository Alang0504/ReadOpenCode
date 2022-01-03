package com.example.read_open_code.model.po;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserPo {
    private Integer id;
    private String loginid;
    private String password;
    private String name;
    private Integer sex;
    private Integer age;
    private String address;
    private Date birthday;
    private String signature;
    private Date createtime;
    private Date updatetime;
    private String phone;
    private String email;
    private Integer role;
    private Integer del_flag;
    private String photo_path;
    private List<RolePo> rolePoList;
}
