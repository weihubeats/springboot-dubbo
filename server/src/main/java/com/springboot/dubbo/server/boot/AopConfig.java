package com.springboot.dubbo.server.boot;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * <p>Project:com.midea.jr <p>
 * <p>Module:finance.platform.war <p>
 * <p>Description:事务配置 <p>
 *
 * @author cengzh
 * @date 2018年3月24日 上午9:40:13
 */
@Aspect
@Component
@Order(2)
@Slf4j
public class AopConfig {
	private static final String POINT_CUT = "execution(* com.springboot.dubbo.server.service..*.*(..))";
	private static final String SEPARATOR = System.getProperty("line.separator");

	@Pointcut(POINT_CUT)
	private void pointcut(){}

	@Before(value = "pointcut()")
	public void allBefore(JoinPoint joinPoint) {
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		StringBuilder sb = new StringBuilder();
		//日志打印
        sb.append(SEPARATOR)
				.append("所属类方法:"+className)
				.append("."+methodName)
				.append(SEPARATOR)
				.append("输入参数params:");
		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
            sb.append(JSONObject.toJSONString(arg) + ", ");
		}
		log.info(sb.toString());
	}

	@AfterReturning(value = "pointcut()", returning = "returnObj")
	public void afterReturn(Object returnObj) {
		StringBuilder sb = new StringBuilder();
		sb.append(SEPARATOR);
		if (returnObj != null) {
			 //TODO 处理不要打印所有日志
			if (returnObj instanceof List) {
				List list = (List) returnObj;
				sb.append("返回参数params数据条数: " + list.size());
			} else {
				String result = JSONObject.toJSONString(returnObj);
				sb.append("返回参数params: " + result);
			}
		}
        log.info(sb.toString());
	}

	@AfterThrowing(value ="pointcut()", throwing = "e")
	public void afterThrowing(Throwable e) {
        log.error(e.getMessage(), e);
	}

	@Around(value = "pointcut()")
	public Object allAround(ProceedingJoinPoint joinPoint)throws Throwable {
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();

		long begin = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		Object result = joinPoint.proceed();
		long end =  System.currentTimeMillis();
		sb.append(SEPARATOR)
				.append("所属类方法:"+className)
				.append("."+methodName)
				.append(SEPARATOR)
				.append("环绕通知: ")
				.append("执行时间: ").append(end-begin).append("ms");
        log.info(sb.toString());
		return result;
	}
}
