package com.springJDBC.springJDBC;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import springJDBC.dao.StudentDaoImpl;

@Configuration
public class ConfigureData {
	
	@Bean("dataSource")
	public DataSource getdataSource() {
		DriverManagerDataSource dmsc=new DriverManagerDataSource();
		dmsc.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmsc.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		dmsc.setUsername("root");
		return dmsc;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jt=new JdbcTemplate();
		jt.setDataSource(getdataSource());
		return jt;
	}
	
	@Bean("studentDao")
	public StudentDaoImpl getStudentDaoImpl() {
		StudentDaoImpl sdi=new StudentDaoImpl();
		sdi.setJdbcTemplate(getJdbcTemplate());
		return sdi;
	}
}
