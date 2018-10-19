package com.learn.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-08-13 23:48
 * @Copyright: 2018
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MethodAnnotation {
		String version();
		String importLvl();
}
