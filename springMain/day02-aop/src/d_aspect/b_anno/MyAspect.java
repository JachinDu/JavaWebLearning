package d_aspect.b_anno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*
* 切面类：含有多个通知
* */
@Component
@Aspect
public class MyAspect {

    //前置通知，可有参数
    //切入点当前有效
//    @Before("execution(* d_aspect.b_anno.UserServiceImpl.*(..))")
    public void myBefore(JoinPoint joinPoint) {
        System.out.println("前置通知: "+joinPoint.getSignature().getName());
    }


    //声明公共切入点
    @Pointcut("execution(* d_aspect.b_anno.UserServiceImpl.*(..))")
    private void myPointCut() {
        //必须这样才算声明公共切入点，以后所有通知可引用该切入点，不像上一个
    }
    //后置通知(引用了公共切入点）
//    @AfterReturning(value = "myPointCut()",returning = "ret")
    public void myAfterRetruning(JoinPoint joinPoint,Object ret) {
        System.out.println("后置通知: "+joinPoint.getSignature().getName()+",-->"+ret);
    }

    //环绕通知
    //返回值必须是Object，参数类型必须是ProceedingJoinPoint
//    @Around(value = "myPointCut()")
    public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("前");
        //必须手动执行目标方法
        Object obj = joinPoint.proceed();
        System.out.println("后");
        return obj;
    }

    //抛出异常通知(参数必须有）
    //参数二获得异常信息，类型必须是Throwable
//    @AfterThrowing(value = "myPointCut()",throwing = "e")
    public void myAfterThrowing(JoinPoint joinPoint,Throwable e) {
        System.out.println("抛出异常通知 : " + e.getMessage());
    }

    //最终通知
    @After("myPointCut()")
    public void myAfter(JoinPoint joinPoint) {
        System.out.println("最终通知");
    }

}
