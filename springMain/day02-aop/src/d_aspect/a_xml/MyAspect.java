package d_aspect.a_xml;

import org.aopalliance.intercept.Joinpoint;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/*
* 切面类：含有多个通知
* */
public class MyAspect {
    //前置通知，可有参数
    public void myBefore(JoinPoint joinPoint) {
        System.out.println("前置通知: "+joinPoint.getSignature().getName());
    }

    //后置通知
    public void myAfterRetruning(JoinPoint joinPoint,Object ret) {
        System.out.println("后置通知: "+joinPoint.getSignature().getName()+",-->"+ret);
    }

    //环绕通知
    //返回值必须是Object，参数类型必须是ProceedingJoinPoint
    public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("前");
        //必须手动执行目标方法
        Object obj = joinPoint.proceed();
        System.out.println("后");
        return obj;
    }

    //抛出异常通知(参数必须有）
    //参数二获得异常信息，类型必须是Throwable
    public void myAfterThrowing(JoinPoint joinPoint,Throwable e) {
        System.out.println("抛出异常通知 : " + e.getMessage());
    }

    //最终通知
    public void myAfter(JoinPoint joinPoint) {
        System.out.println("最终通知");
    }

}
