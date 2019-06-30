package com.jachin.springbootday06datajpa.repository;


import com.jachin.springbootday06datajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


//继承JpaRepository，完成对数据库的相关操作，两个泛型参数（1：操作实体类，2：实体类中主键类型）
public interface UserRepository extends JpaRepository<User,Integer> {


}
