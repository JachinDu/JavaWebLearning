package h_annotation.a_ioc;

import org.springframework.stereotype.Component;

@Component("userService") //取代<bean>标签的
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("a_ioc addUser()");
    }

    public UserServiceImpl() {
        System.out.println("被new了");
    }
}
