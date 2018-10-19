package com.learn.reflect;

import com.google.errorprone.annotations.concurrent.UnlockMethod;
import org.omg.CORBA.OBJ_ADAPTER;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author： ZhuWeiFeng
 * @date： 2018/4/8
 */
@MyAnnotation(name = "ReflectDemo", value = "My First")
public class ReflectSampleDemo {
	private String arv1;
	private String arv2;

	public String getArv1() {
		return arv1;
	}
	public void setArv1(String arv1) {
		this.arv1 = arv1;
	}

	public String getArv2() {
		return arv2;
	}

	public void setArv2(String arv2) {
		this.arv2 = arv2;
	}

	public ReflectSampleDemo(String arv1) {
		this.arv1 = arv1;
	}

	public ReflectSampleDemo() {
	}

	public static void main(String[] args) throws NoSuchFieldException {
		Method[] methods = ReflectSampleDemo.class.getMethods();
//		for (Method method : methods) {
//			System.out.println("Method: " + method.getName());
//		}
		int modifier = ReflectSampleDemo.class.getModifiers();
		System.out.println(Modifier.isAbstract(modifier));
		System.out.println(Modifier.isPublic(modifier));

		Package pack = ReflectSampleDemo.class.getPackage();
		System.out.println(pack.getName());

		Class[] classes = ReflectSampleDemo.class.getInterfaces();
		for (Class aClass : classes) {
			System.out.println(aClass.getName());
		}

		Constructor[] constructors = ReflectSampleDemo.class.getConstructors();
		for (Constructor constructor : constructors) {
			System.out.println(constructor.getName());
		}
		// 获取指定参数类型的构造器
		Class[] params = new Class[]{String.class};
		try {
			Constructor constructor = ReflectSampleDemo.class.getConstructor(params);
			System.out.println(constructor.getName());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		try {
			Method method  = ReflectSampleDemo.class.getMethod("setArv1", String.class);
			System.out.println(method.getName());
			Object retVal = method.invoke(new ReflectSampleDemo(), "parameter-value1");
//			System.out.println(retVal);
			Annotation[] annotations = method.getAnnotations();
			System.out.println("size = " + annotations.length );
			for (Annotation annotation : annotations) {
				System.out.println(((UnlockMethod)annotation).value());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Field privateStringField = ReflectSampleDemo.class.getDeclaredField("arv1");
		privateStringField.setAccessible(true);

		Annotation[] annotations = ReflectSampleDemo.class.getAnnotations();
		for (Annotation annotation : annotations) {
			MyAnnotation myAnnotation = (MyAnnotation) annotation;
			System.out.println(myAnnotation.name());
			System.out.println(myAnnotation.value());
		}

		Annotation annotation = ReflectSampleDemo.class.getAnnotation(MyAnnotation.class);
		System.out.println(((MyAnnotation) annotation).value());
	}
}
