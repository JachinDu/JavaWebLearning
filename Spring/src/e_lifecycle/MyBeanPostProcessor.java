package e_lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanPostProcessor implements BeanPostProcessor {

    //初始化方法前spring自动调用
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("前方法");
        return o;  //将传入的再传出
    }

    //初始化方法后spring自动调用
    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("后方法");
        //生成jdk代理
//        return o;//将传入的再传出
        return Proxy.newProxyInstance(
                MyBeanPostProcessor.class.getClassLoader(),
                o.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("----------开启事务");
                        //执行目标方法
                        Object obj = method.invoke(o, args);
                        System.out.println("--------提交事务");
                        return obj;
                    }
                }
        );
    }
}
