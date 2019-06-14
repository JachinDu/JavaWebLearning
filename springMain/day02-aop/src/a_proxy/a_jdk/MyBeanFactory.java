package a_proxy.a_jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {

    public static UserService createService() {
        //1目标类
        UserService userService = new UserServiceImpl();
        //2切面类
        MyAspect myAspect = new MyAspect();
        /*
        *3代理类：将目标类（切入点）和切面类（通知）结合--->切面
        *
        * Proxy.newProxyInstance
        *   参数1：loader：类加载器，动态代理类运行时创建，任何类都需要类加载器将其加载到内存。
        *       一般情况：采用当前类.class.getClassLoader();
        *                目标类实例.getClass().getClassLoader();
        *   参数2：interfaces：代理类要实现到所有接口
        *       方式1：目标实例.getClass().getInterfaces() ,注意：只能获得自己到接口，不能获得父元素接口
        *       方式2：new Class[]{UserService.class}
        *   参数3：InvocationHandler：处理类，是一个接口，必须进行实现类，一般采用匿名内部方式
        *       提供invoke方法，代理类的每一个方法执行时，都将调用一次invoke
        *           参数1:Object proxy：代理对象
        *           参数2：Method method：代理对象当前执行的方法的描述对象（反射）
        *                   执行方法名：method.getName()
        *                   执行方法：method.invoke(对象，实际参数)
        *           参数3：Object[] args：方法的实际参数
        * */
        UserService proxyService = (UserService) Proxy.newProxyInstance(
                MyBeanFactory.class.getClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        //前执行
                        myAspect.before();

                        //执行目标类方法
                        Object obj = method.invoke(userService, args);

                        //后执行
                        myAspect.after();
                        return obj;
                    }
                }
        );

        return proxyService;
    }

}
