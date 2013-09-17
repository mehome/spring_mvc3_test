package net.i77soft.spring.mvc3.service;

import java.util.ArrayList;
import java.util.List;

import net.i77soft.spring.mvc3.model.Person;

import org.springframework.stereotype.Service;

@Service
public class SpringTestService {
	/**
	 * This method supposed to be returning a Collection of Person objects from a DAO layer
	 * For this tutorial, let us just hard-code this List of Person objects
	 */
	public List<Person> getDummyList() {
		List<Person> list = new ArrayList<Person>();
		Person p1 = new Person();
		p1.setId(12345);
		p1.setName("Paul");
		p1.setAge(27);
		p1.setAddress("Dalaguete, Cebu");

		Person p2 = new Person();
		p2.setId(54321);
		p2.setName("Sydney");
		p2.setAge(25);
		p2.setAddress("Cebu City");

		list.add(p1);
		list.add(p2);
		return list;
	}
}
