package com.learn.jdkdynamicproxy;

import com.learn.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author： ZhuWeiFeng
 * @date： 2018/4/8
 */
public class JDKDynamicProxy implements InvocationHandler{
	private Object delegate;

	public JDKDynamicProxy(Object delegate) {
		this.delegate = delegate;
	}

	public JDKDynamicProxy() {
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("I'm proxy ");
		Object result = method.invoke(delegate, args);
		System.out.println("Proxy exit");
		return result;
	}

	public Object getProxy(ClassLoader cl, Class clazz){
		return Proxy.newProxyInstance(cl, new Class[]{clazz}, this);
	}

	public static void main(String[] args) {
		TestService ts = new TestServiceImpl("service bean instance");
		if(ts instanceof TestService){
			System.out.println("Yep, i'm the one you need");
		}

		TestService proxy = (TestService) new JDKDynamicProxy(ts).getProxy(TestService.class.getClassLoader(), TestService.class);
		proxy.say();
		if (proxy instanceof TestService) {
			System.out.println("Proxy is also seen as the bean");
		}
	}
}
