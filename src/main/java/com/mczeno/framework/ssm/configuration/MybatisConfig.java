package com.mczeno.framework.ssm.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(value = "com.mczeno.framework.ssm.mapper")
public class MybatisConfig {
	
	@Value("${datasource.driver}")
	private String driverClassName;
	
	@Value("${datasource.url}")
	private String jdbcUrl;

	@Value("${datasource.username}")
	private String username;

	@Value("${datasource.password}")
	private String password;

    @Value("${datasource.readOnly}")
    private boolean readOnly;

    @Value("${datasource.connectionTimeout}")
    private long connectionTimeout;

    @Value("${datasource.idleTimeout}")
    private long idleTimeout;

    @Value("${datasource.maxLifetime}")
    private long maxLifetime;

    @Value("${datasource.maximumPoolSize}")
    private int maximumPoolSize;

	@Bean
	public DataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setJdbcUrl(jdbcUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setReadOnly(readOnly);
        dataSource.setConnectionTimeout(connectionTimeout);
        dataSource.setIdleTimeout(idleTimeout);
        dataSource.setMaxLifetime(maxLifetime);
		dataSource.setMaximumPoolSize(maximumPoolSize);
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
//		sqlSessionFactoryBean.settype
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
