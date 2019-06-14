package e_lifecycle;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("e_lifecycle addUser()");
    }

    public void myInit() {
        System.out.println("初始化");
    }

    public void myDestroy() {
        System.out.println("销毁");
    }


}
