package basic1;

public class Employee {
	String name;
	int age;
	String designation;
	double salary;
	
	public Employee(String name) {   //Employee类的构造方法
		this.name = name;
	}
	//设置age
	public void empAge(int empAge) {
		age = empAge; 
	}
	//print method
	public void printEmployee() {
		System.out.println(name);
		System.out.println(age);
	}
}
