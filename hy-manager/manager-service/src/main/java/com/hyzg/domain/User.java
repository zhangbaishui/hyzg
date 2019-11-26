package com.hyzg.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @Auther:
 * @Date:
 * @Description:
 */
@Table(name = "tb_admin")
@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    @Column(name = "role_id")
    private Long roleId;
    private String perms;
}
