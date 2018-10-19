package com.learn.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author： ZhuWeiFeng
 * @data： 2018/3/20
 */
public class MyInvocationHandler implements InvocationHandler{
	/** 们既然要做代理，我们必须知道我们是给谁做代理，这里的obj就是被代理者 */
	private Object target;

	MyInvocationHandler() {
		super();
	}

	MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		/**把我们想要通过代理者给被代理者追加的操作都写在invoke方法里面 */
		if("getName".equals(method.getName())){
			System.out.println("++++++before " + method.getName() + "++++++");
			Object result = method.invoke(target, args);
			System.out.println("++++++after " + method.getName() + "++++++");
			return result;
		}else{
			Object result = method.invoke(target, args);
			return result;
		}

	}
}
