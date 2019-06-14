package com.imooc.collection;

import java.util.Objects;

public class Course {
    public String id;

    public String name;

    public Course(String id, String name){
        this.id = id;
        this.name = name;
    }
    public Course(){};

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public boolean equals(Object obj)
    {
        if(this == obj)
        {
            return true;
        }
        if (obj == null)
            return false;
        if(!(obj instanceof Course))
            return false;
        Course course = (Course) obj;
        if(this.name == null){
            if(course.name == null)
                return true;
            else
                return false;
        }
        else {
            if(this.name.equals(course.name))
                return true;
            else
                return false;
        }
    }
}
