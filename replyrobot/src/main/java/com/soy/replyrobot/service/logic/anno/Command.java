package com.soy.replyrobot.service.logic.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>此注解用于声明方法绑定的指令名称</p>
 * @author zhengsiyou
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Command {
	
	/**
	 * <p>指令名称</p>
	 * @author zhengsiyou
	 * @return 
	 */
	String value();
	
	/**
	 * <p>描述信息，如果设置的话会在帮助信息中提示</p>
	 * @author zhengsiyou
	 * @return 
	 */
	String description() default "";
}
