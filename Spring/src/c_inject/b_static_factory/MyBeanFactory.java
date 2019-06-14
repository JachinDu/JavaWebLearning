package c_inject.b_static_factory;
/*
* 静态工厂
* */
public class MyBeanFactory {
    public static UserService createService() {
        return new UserServiceImpl();
    }
}
