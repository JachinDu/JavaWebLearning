package a_ioc;

import b_di.BookServiceImpl;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("a_ioc addUser()");
    }

    public UserServiceImpl() {
        System.out.println("被new了");
    }
}
