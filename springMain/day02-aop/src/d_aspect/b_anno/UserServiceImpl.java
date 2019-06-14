package d_aspect.b_anno;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("a_proxy.a_jdk addUser()");
    }

    @Override
    public void updateUser() {
        System.out.println("c_aspect.a_xml updateUser()");
//        int i = 1/0;

    }

    @Override
    public void deleteUser() {
        System.out.println("c_aspect.a_xml deleteUser()");

    }
}
