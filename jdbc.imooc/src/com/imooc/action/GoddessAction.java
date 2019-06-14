package com.imooc.action;

import com.imooc.dao.GoddessDao;
import com.imooc.model.Goddess;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import java.sql.SQLException;
import java.util.*;

public class GoddessAction {

    public void add(Goddess goddess) throws SQLException {
        GoddessDao dao = new GoddessDao();
        dao.addGoddess(goddess);
    }

    public void edit(Goddess goddess) throws SQLException {
        GoddessDao dao = new GoddessDao();
        dao.updateGoddess(goddess);
    }

    public void del(Integer id) throws SQLException {
        GoddessDao dao = new GoddessDao();
        dao.delGoddess(id);
    }

//    public List<Goddess> query(){
//        GoddessDao dao = new GoddessDao();
//        return dao.query();
//
//    }

    public List<Goddess> query(List<Map<String,Object>> params) throws SQLException {
        GoddessDao dao = new GoddessDao();
        return dao.query(params);
    }

    public Goddess get(Integer id) throws SQLException {
        GoddessDao dao = new GoddessDao();
        return dao.get(id);
    }

}
