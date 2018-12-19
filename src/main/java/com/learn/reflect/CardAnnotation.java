package com.learn.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author: WeFon
 * @date: 2018-08-13 23:30
 * @Copyright: 2018
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CardAnnotation {
		String type();
		String color();

}
