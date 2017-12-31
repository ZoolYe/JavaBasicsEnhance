package zool.java.basics.beanutils;

import java.util.Date;

public class Persion {	//javaBean

	//只有对外提供了get或set方法后才能称之为属性
	private String name;//字段
	private int age;//字段
	private String password;//字段
	private Date birthday;
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
