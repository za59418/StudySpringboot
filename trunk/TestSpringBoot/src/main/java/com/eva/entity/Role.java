package com.eva.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by 01348085 on 2017/7/12.
 */
@Entity
@Table(name="t_role")
public class Role implements Serializable {
    private static final long serialVersionUID = -8447943692135421632L;

    @Id
    @GeneratedValue
    private Long id;
    private String rolename;


    @OneToMany(mappedBy = "role_id")
    private Set<Permission> permissions;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
