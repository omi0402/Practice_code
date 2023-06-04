package com.jtcindia.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyClient {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JTCAppConfig.class);
		CustomerDAO custDAO = (CustomerDAO) ctx.getBean("custDAO");
		Customer cust = new Customer(345, "google", "google@gmail", 965434, "Pune");
		custDAO.addCustomer(cust);
		List<Customer> mylist1 = custDAO.getAllCustomers();
		mylist1.forEach(mycust -> System.out.println(mycust));
		System.out.println("-----------");
		List<Customer> mylist2 = custDAO.getCustomersByCity("Noida");
		mylist2.forEach(mycust -> System.out.println(mycust));// forEach LamdaExpression
		List<Customer> mylist3 = custDAO.getCustomersByCity("Delhi");
		mylist3.forEach(mycust -> System.out.println(mycust));// forEach LamdaExpression
		System.out.println("Done!!!");
	}
}
