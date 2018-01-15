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
@Table(name="t_permission")
public class Permission implements Serializable {
    private static final long serialVersionUID = -899834302190270345L;

    @Id
    @GeneratedValue
    private Long id;
    private String des;
    private Long role_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }
}
