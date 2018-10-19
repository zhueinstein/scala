package com.learn.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description:TODO
 * @author: WeFon
 * @date: 2018-08-13 23:01
 * @Copyright: 2018
 */
public class ReflectTest20180813 {

		public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
				String className = "com.learn.reflect.CardInstance";

				reflect_06(className);
		}

		/**
		 * 方法上的注解
		 * @param className
		 */
		private static void reflect_06(String className) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
				Class clazz = Class.forName(className);
				Constructor constructor = clazz.getConstructor(String.class, Long.class, String.class);
				Object instance = constructor.newInstance("VIP0001", 3000000L, "WeeFon");

				Method method = clazz.getMethod("methodAnnotation", null);
				Annotation annotation = method.getAnnotation(MethodAnnotation.class);
				MethodAnnotation methodAnnotation = (MethodAnnotation)annotation;
				System.out.println(methodAnnotation.version() + " _______ " + methodAnnotation.importLvl());
				method.invoke(instance, null);
		}

		/**
		 * 类上的注解
		 * @param className
		 * @throws ClassNotFoundException
		 */
		private static void reflect_05(String className) throws ClassNotFoundException {
				// 获取Class对象
				Class clazz = Class.forName(className);
				// 获取注解对象
				Annotation annotation = clazz.getAnnotation(CardAnnotation.class);
				// 获取注解对象类型
				CardAnnotation cardAnnotation = (CardAnnotation)annotation;
				System.out.println(cardAnnotation.type() + "---------" + cardAnnotation.color());
		}

		/**
		 * 调用有参数的方法
		 * @param className
		 */
		private static void reflect_04(String className) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
				// 首先要获取对象
				Object object = reflect_01(className);
				Class clazz = Class.forName(className);
				Method addMethod = clazz.getMethod("setBalance", Long.class);
				addMethod.invoke(object, 1000L);
				// 获取指定方法
				Method method = clazz.getMethod("balanceReduce", Long.class);
				method.invoke(object, 100L);

				// 获取字段
				Field field = clazz.getDeclaredField("balance");
				field.setAccessible(true);
				// 通过对象获取值
				System.out.println(field.get(object));


		}

		/**
		 * 调用无参数的方法
		 * @param className
		 */
		private static void reflect_03(String className) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
				// 首先要获取对象
				Object object = reflect_01(className);
				Class clazz = Class.forName(className);
				// 获取指定方法
				Method method = clazz.getMethod("balanceAutoGen", null);
				// 通过对象去invoke方法
				Long lM = (Long)method.invoke(object, null);
				System.out.println(lM);

		}

		/**
		 *  有参数构造对象, 先获取class，获取指定参数的构造函数，使用构造的newInstance生成对象
		 * @param className
		 */
		private static void reflect_02(String className) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
				Class clazz = Class.forName(className);

				// 指定参数的构造函数
				Constructor constructor =  clazz.getConstructor(String.class, Long.class, String.class);
				Object object = constructor.newInstance("001", 30000L, "WeeFon");
				System.out.println(object);
		}

		/**
		 * 使用无参构造对象
		 * @param className
		 * @throws ClassNotFoundException
		 */
		private static Object reflect_01(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
				// 1、 获取Class对象
				Class clazz = Class.forName(className);
				// 2、获取对象，使用构造函数
				Object object = clazz.newInstance();
				System.out.println(object);
				return object;
		}
}
