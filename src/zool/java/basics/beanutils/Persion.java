package zool.java.basics.beanutils;

import java.util.Date;

public class Persion {	//javaBean

	//ֻ�ж����ṩ��get��set��������ܳ�֮Ϊ����
	private String name;//�ֶ�
	private int age;//�ֶ�
	private String password;//�ֶ�
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