package com.demo.common.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class GlobalInterceptor implements Interceptor {

	public void intercept(Invocation inv) {
		// TODO Auto-generated method stub
		System.out.println("启动全局拦截器Before invoking " + inv.getActionKey());
		inv.invoke();
		System.out.println("结束全局拦截器After invoking " + inv.getActionKey());
	}

}
