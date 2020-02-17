import java.io.Serializable;

/**
 * @description:
 * @Author: JachinDo
 * @Date: 2019/11/28 13:47
 */
public class Student implements Cloneable, Serializable {
    private int id;
    private String name;
//    private String address;



    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
//    {
//        address = "kk";9
//    }

//    public int getId() {
//        return id;
//    }
//
    public void setId(int id) {
        this.id = id;
    }


    public Student() {
    }

    public void shuchu() {
        System.out.println("kkkkkkkkk " + id);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
