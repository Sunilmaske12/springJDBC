package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import entity.Customer;

public class RowMapperImpl implements RowMapper<Customer> {

	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer c= new Customer();
		c.setId(rs.getInt(1));
		c.setName(rs.getString(2));
		c.setVillage(rs.getString(3));
		return c;
	}

}
