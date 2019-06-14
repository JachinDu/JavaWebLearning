package h_annotation.b_web;

import org.springframework.stereotype.Repository;

//dao层用@Repository
@Repository("studentDao")
public class StudentDaoImpl implements StudentDao{
    @Override
    public void save() {
        System.out.println("dao");
    }
}
