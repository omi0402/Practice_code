package com.jtcindia.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("custDAO")
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	JdbcTemplate jtemp;
	public void addCustomer(Customer cust) {
		String SQL = "insert into customer values(?,?,?,?,?)";
		jtemp.update(SQL, cust.getCid(), cust.getCname(), cust.getEmail(), cust.getPhone(), cust.getCity());
	}
	public List<Customer> getAllCustomers() {
		String SQL = "select * from customer";
		List<Customer> mylist = jtemp.query(SQL, new CustomerRowMapper());
		return mylist;
	}	
	public List<Customer> getCustomersByCity(String city) {
	String SQL="select * from customer where city=?";
	List<Customer> mylist = jtemp.query(SQL, new CustomerRowMapper(),city);
	return mylist;
	}
}

	

