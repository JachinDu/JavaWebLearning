package f_setter_invasion;

public class Person {
    private int age;
    private String pname;

    private Address homeAddr;
    private Address compAddr;

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", pname='" + pname + '\'' +
                ", homeAddr=" + homeAddr +
                ", compAddr=" + compAddr +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Address getHomeAddr() {
        return homeAddr;
    }

    public void setHomeAddr(Address homeAddr) {
        this.homeAddr = homeAddr;
    }

    public Address getCompAddr() {
        return compAddr;
    }

    public void setCompAddr(Address compAddr) {
        this.compAddr = compAddr;
    }
}
