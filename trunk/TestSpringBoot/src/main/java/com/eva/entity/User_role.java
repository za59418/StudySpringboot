package com.eva.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by 01348085 on 2017/7/12.
 */
@Entity
@Table(name="t_user_role")
public class User_role implements Serializable {
    private static final long serialVersionUID = -2973851288985231671L;
    @Id
    @GeneratedValue
    private Long id;

    private Long user_id;
    private Long role_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }
}
