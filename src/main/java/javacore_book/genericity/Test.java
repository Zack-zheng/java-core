package javacore_book.genericity;

import java.util.ArrayList;

/**
 * 泛型的必要性
 * 
 * @author Zach_zheng
 * 
 */
public class Test {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		//创建一只狗
		Dog dog = new Dog();
		//放入到集合
		al.add(dog);
		
		//取出(此时需要强转化类型)
		Dog temp = (Dog) al.get(0);//都不会报错
		//Cat temp1 = (Cat) al.get(0);//编译不报错，但是运行就会报java.lang.ClassCastException
		
	}
}

class Dog {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private int age;

}

class Cat {
	private String colour;

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private int age;
}