package com.juanodsk.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.juanodsk.ecommerce.repository")
public class DatabaseConfig {

    @Bean
    @Primary
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ecommerce?allowPublicKeyRetrieval=true&useSSL=false&useTimezone=true&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        return dataSource;
    }
}
