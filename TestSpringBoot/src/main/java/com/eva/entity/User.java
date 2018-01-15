package com.eva.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by 01348085 on 2017/7/6.
 */
@Entity
@Table(name="t_user")
public class User implements Serializable{

    private static final long serialVersionUID = 5150395357126772276L;
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "user_name")
    private String userName;
    private String password;
    private int sex;
    private int age;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="t_user_role",
            joinColumns={@JoinColumn(name="user_id",referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="role_id",referencedColumnName="id")})
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
