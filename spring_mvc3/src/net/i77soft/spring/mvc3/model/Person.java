package net.i77soft.spring.mvc3.model;

public class Person {
	private int id;
	private String name;
	private int age;
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		/*
		sb.append("\nname : " + name);
		sb.append("\nage : " + age);
		sb.append("\naddress : " + address);
		//*/

		sb.append(getClass()).append("[")
		.append("id=").append(id).append(", ")
		.append("name=").append(name).append(", ")
		.append("age=").append(age).append(", ")
		.append("address=").append(address).append("]");

		return sb.toString();
	}
}
