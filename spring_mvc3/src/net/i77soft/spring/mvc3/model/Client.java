package net.i77soft.spring.mvc3.model;

/**
 * 自定义一个POJO
 */
public class Client {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(getClass()).append("[")
		.append("name=").append(name).append("]");

		return sb.toString();
	}
}
