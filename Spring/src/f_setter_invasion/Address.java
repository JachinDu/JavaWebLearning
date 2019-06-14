package f_setter_invasion;

public class Address {
    private int tel;
    private String addr;

    @Override
    public String toString() {
        return "Address{" +
                "tel=" + tel +
                ", addr='" + addr + '\'' +
                '}';
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
