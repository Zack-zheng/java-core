package javaReflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * -verbose:class 命令运行class的时候会动态加载所有的类
 */
/**
 * java反射机制原理，常用于框架技术实现。例如最基本的spring注入
 * 
 * 通过classloader的使用可以获得一个类中的filed和method（属性和方法）
 * 
 * @author Jack_zheng
 * 
 */

public class TestReflection {
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		String str = "javaReflection.T";
		Class c = Class.forName(str);
		Object o = c.newInstance();
		Method[] methods = c.getMethods();
		for (Method m : methods) {
			if (m.getName().equals("mm")) {
				m.invoke(o);
			} else if (m.getName().equals("m1")) {
				m.invoke(o, 1, 2);
			}else if(m.getName().equals("getS")){
				Class returnType = m.getReturnType();
				System.out.println(returnType.getName());
			}
		}
	}
}

class T {
	static {
		System.out.println("T loaded!");
	}

	public T() {
		System.out.println("T constructed");
	}

	int i;
	String s;

	private void m1(int i, int j) {
		this.i = i + j;
		System.out.println(this.i);
	}

	private void mm() {
		// TODO Auto-generated method stub
		System.out.println("mm invoked");
	}

	public String getS() {
		return s;
	}
}