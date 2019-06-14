package a_proxy.b_cglib;

import org.junit.Test;

public class TestCglib {
    @Test
    public void demo1() {
        UserServiceImpl userService = MyBeanFactory.createService();
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();
    }
}
