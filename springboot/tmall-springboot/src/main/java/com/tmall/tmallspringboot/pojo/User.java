package com.tmall.tmallspringboot.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    private String password;
    private String name;
    private String salt;

    // 用于获取匿名，其实就是前后保留，中间换成星星，如果长度只有2或者1，单独处理一下。
    @Transient
    private String anonymousName;

    public String getAnonymousName() {
        if (null != anonymousName) {
            return anonymousName;
        }
        if (null == name) {
            anonymousName = null;
        } else if (name.length() <= 1) {
            anonymousName = "*";
        } else if (name.length() == 2) {
            anonymousName = name.substring(0, 1) + "*";
        } else {
            StringBuilder stringBuilder = new StringBuilder(name);
            for (int i = 1; i < name.length() - 1; i++) {
                stringBuilder.setCharAt(i,'*');
            }
            anonymousName = stringBuilder.toString();
        }
        return anonymousName;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }


    public void setAnonymousName(String anonymousName) {
        this.anonymousName = anonymousName;
    }


}
