package com.imooc.test;

import com.imooc.action.GoddessAction;
import com.imooc.model.Goddess;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class TestAction {
    public static void main(String[] args) throws SQLException {
        GoddessAction action = new GoddessAction();

        Goddess g = new Goddess();

        g.setUser_name("小青");
        g.setSex(1);
        g.setAge(25);
        g.setBirthday(new Date());
        g.setEmail("xiaoqing@163.com");
        g.setMobile("15688888888");
        g.setIsdel(0);

        //action.add(g);
        action.del(4);
    }
}
