package com.jtcindia.spring;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = {"com.jtcindia.spring"})
public class JTCAppConfig {
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/myjtcdb5");
		bds.setUsername("root");
		bds.setPassword("Govinda1995@");
		bds.setMaxIdle(5);
		return bds;
		}
		@Bean(name = "jtemp")
		public JdbcTemplate getJdbcTemplate(DataSource dataSource){
		JdbcTemplate jtemp = new JdbcTemplate(dataSource);
		return jtemp;
	}
}
