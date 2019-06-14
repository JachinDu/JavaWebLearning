package pkg1;

public class Person {

    int id;
    String name;
    public Person(int id,String name){
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "编号: " + this.id + " 姓名：" + this.name;
    }
}

