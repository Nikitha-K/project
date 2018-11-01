package javacore;

public class employee {
	String name;
	int code;
	int sal;
	public employee(String name, int code, int sal) {
		
		this.name = name;
		this.code = code;
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "employee [name=" + name + ", code=" + code + ", sal=" + sal + "]";
	}

}
