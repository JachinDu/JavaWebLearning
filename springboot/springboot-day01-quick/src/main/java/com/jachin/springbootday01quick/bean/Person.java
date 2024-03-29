package com.jachin.springbootday01quick.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;


/*
* 将配置文件中配置的每一个属性的值，映射到这个组件中
* @ConfigurationProperties: 告诉springboot将本类中的所有属性和配置文件中相关的配置进行绑定
*   prefix = "person"： 配置文件中哪个下面的所有属性进行一一映射
* 只有这个组件是容器中的组件，才能提供ConfigurationProperties的功能，所以要将该类加入容器
* */
@Component
@ConfigurationProperties(prefix = "person")
//打开数据校验，ConfigurationProperties才可使用
@Validated
//加载指定配置文件中的数据
//@PropertySource(value = {"classpath:person.properties"})
public class Person {
    //数据校验：该属性必须为邮箱格式
//    @Email
    private String lastName;

    private Integer age;
    private Boolean boss;
    private Date birth;

    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;


    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
