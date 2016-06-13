package com.jd.ls;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/6/8.
 */

@Component
@Aspect
public class AopTest {

	//如果要设置多个切点可以使用 || 拼接
	@Pointcut("execution(* com.jd.ls.Hello.*(..))")
	private void anyMethod() {
	}

	@Before(value = "anyMethod()")
	public void doBefore(JoinPoint joinPoint) {

		System.out.println("前置通知");
		System.out.println("方法签名：" + joinPoint.getSignature().toLongString());
	}

	@AfterReturning(value = "anyMethod()", returning = "result")
	public void doAfter(JoinPoint jp, String result) {

		System.out.println("后置通知, result:\t" + result);
	}

	@After("anyMethod()")
	public void after() {

		System.out.println("最终通知");
	}

	@AfterThrowing(value = "anyMethod()", throwing = "e")
	public void doAfterThrow(JoinPoint joinPoint, Throwable e) {
		e.printStackTrace();
	}

	@Around("anyMethod()")
	public Object doBasicProfiling(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("进入环绕通知");
		System.out.println("目标类名称：" + joinPoint.getTarget().getClass().getName());
		System.out.println("方法签名：" + joinPoint.getSignature().toLongString());
		System.out.println("方法参数：");
		for (Object o : joinPoint.getArgs()) {
			System.out.println(o.getClass().getName() + ":\t" + o.toString());
		}
		System.out.println("target" + joinPoint.getTarget());
		System.out.println("staticPart:" + joinPoint.getStaticPart().toShortString());
		System.out.println("kind:" + joinPoint.getKind());
		System.out.println("sourceLocation:" + joinPoint.getSourceLocation());
		Object object = joinPoint.proceed();// 执行该方法
		System.out.println("执行结果" + JSON.toJSONString(object));
		System.out.println("退出方法");
		System.out.println(joinPoint.toLongString());
		return object;
	}

}
