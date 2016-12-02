package com.soy.replyrobot.service.baidumap.paramtool;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>指定被注解元素是否必需</p>
 * @author zhengsiyou
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Documented
public @interface Required {
	
	/**
	 * 表示字段未设定值
	 */
	public static final String EMPTY = "\0\0";
	
	/**
	 * <p>是否必须</p>
	 * @author zhengsiyou
	 * @return 
	 */
	boolean value() default true;
	
	/**
	 * <p>相关字段</p>
	 * <p>如果有此字段，那么当此字段为{@link #relationValue}时，被注解的字段为必须，否则可选。</p>
	 * @see #relationValue
	 * @author zhengsiyou
	 * @return 
	 */
	String relation() default "";
	
	/**
	 * <p>相关字段值</p>
	 * @see #relation
	 * @author zhengsiyou
	 * @return 
	 */
	String[] relationValues() default "";
	
}
