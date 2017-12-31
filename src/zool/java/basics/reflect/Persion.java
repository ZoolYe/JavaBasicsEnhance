package zool.java.basics.reflect;

import java.io.InputStream;
import java.util.List;

public class Persion {

	private static int pass;
	public String name;
	private int age;
	
	public Persion() {
		System.out.println("Persion()");
	}
	
	public Persion(String name) {
		this.name = name;
		System.out.println("Persion(String name)");
	}
	
	public Persion(int age) {
		this.age = age;
		System.out.println("Persion(int age)");
	}
	
	public Persion(String name ,int age) {
		this.name = name;
		this.age = age;
		System.out.println("Persion(String name ,int age)");
	}
	
	private Persion(List list) {
		System.out.println("list");
	}
	
	public void run() {
		System.out.println("run...");
	}
	
	public void run(String mesg,int index) {
		System.out.println(mesg+" : "+index);
	}
	
	public Class[] run(String mesg,int[] arr) {
		System.out.println(mesg+" : "+arr);
		return new Class [] {String.class};
	}
	
	private void show(InputStream is) {
		System.out.println(is);
	}
	
	public static void function(int num) {
		System.out.println(num);
	}
	
	public static void main(String[] args) {
		System.out.println("persion main...");
	}
	
}
