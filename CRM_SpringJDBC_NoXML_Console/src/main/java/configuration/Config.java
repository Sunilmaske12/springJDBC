package configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import dao.CustomerDao;

@Configuration
@ComponentScan("dao")
public class Config {
	
	@Bean
	public CustomerDao getCustomerDao() {
		CustomerDao cd = new CustomerDao();
		cd.setJdbcTemplate(getJdbcTemplate());
		return cd;
	}

	private JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jt=new JdbcTemplate();
		jt.setDataSource(getDataSource());
		return jt;
	}

	private DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dmds=new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		dmds.setUsername("root");
		return dmds;
	}
	
}
