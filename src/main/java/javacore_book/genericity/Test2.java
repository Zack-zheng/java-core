package javacore_book.genericity;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 泛型的必要性
 * 
 * @author Zach_zheng
 * 
 */
public class Test2 {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		// 创建一只狗
		Dog dog = new Dog();
		// 放入到集合
		al.add(dog);

		// 取出(此时需要强转化类型)
		Dog temp = (Dog) al.get(0);// 都不会报错
		// Cat temp1 = (Cat)
		// al.get(0);//编译不报错，但是运行就会报java.lang.ClassCastException

//		Gen<String> gen1 = new Gen<String>("1");
//		gen1.showTypeName();
//		Gen<Integer> gen2 = new Gen<Integer>(1);
//		gen2.showTypeName();
		Gen<Bird> gen3 = new Gen<Bird>(new Bird());
		gen3.showTypeName();
	}
}

class Bird {
	public void test1() {
		System.out.println("aa");
	}

	public void count(int a, int b) {
		System.out.println(a + b);
	}
}

// 定义一个类
class Gen<T> {
	private T o;

	public Gen(T a) {
		o = a;
	}

	// 得到T的类型名称
	public void showTypeName() {
		System.out.println("类型是：" + o.getClass().getName());
		// 反射机制
		Method[] m = o.getClass().getMethods();
		for (int i = 0; i < m.length; i++) {
			System.out.println(m[i].getName());
		}

	}
}