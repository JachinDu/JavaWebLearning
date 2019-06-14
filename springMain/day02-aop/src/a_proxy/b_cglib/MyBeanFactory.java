package a_proxy.b_cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {

    public static UserServiceImpl createService() {
        //1目标类
        UserServiceImpl userService = new UserServiceImpl();
        //2切面类
        MyAspect myAspect = new MyAspect();

        /*
        * 3 代理类，采用cglib，底层创建目标的子类
        * */
        //3.1核心类
        Enhancer enhancer = new Enhancer();
        //3.2确定父类
        enhancer.setSuperclass(userService.getClass());
        //3.3设置回调 MethodInterceptor接口等效于jdk中的InvocationHandler
        /*
        * intercept()等效于jdk的invoke()
        *       参数1，2，3与invoke的一样
        *       参数4：methodProxy方法的代理，通常不用
        * */
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //前
                myAspect.before();
                //执行目标类的方法
                Object obj = method.invoke(userService, objects);
                //执行代理类的父类，即目标类（目标类和代理类是父子关系）
                //methodProxy.invokeSuper(o, objects);

                //后
                myAspect.after();
                return obj;
            }
        });

        //3.4创建代理
        UserServiceImpl proxyService = (UserServiceImpl)enhancer.create();
        return proxyService;
    }

}
