package dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import entity.Customer;

public class CustomerDao {
	
	JdbcTemplate jdbcTemplate;
	
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}



	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	public int insert(Customer c) {
		String insert = "insert into customer (id, name, village) value(?,?,?)";
		int id = jdbcTemplate.update(insert, c.getId(), c.getName(), c.getVillage());
		return id;
	}



	public int delete(int id) {
		String delete = "delete from customer where id = ?";
		int result = this.jdbcTemplate.update(delete, id); 
		return result;
	}
	
	public Customer getCustomer(int id) {
		String get = "select * from customer where id = ?";
		RowMapper<Customer> rm=new RowMapperImpl();
		Customer result = this.jdbcTemplate.queryForObject(get, rm, id); 
		return result;
	}



	public List<Customer> getAll() {
		String all = "select * from customer";
		RowMapper<Customer> rm=new RowMapperImpl();
		List<Customer> c = this.jdbcTemplate.query( all, rm);
		return c;
	}
}
