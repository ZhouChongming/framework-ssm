package tech.mczeno.framework.ssm.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

/**
 * 数据源和 Mybatis 配置
 *
 * @author Chongming Zhou
 * @date 2018-06-29
 */
@Configuration
@MapperScan(value = "tech.mczeno.framework.ssm.mapper")
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

	@Bean("dataSource")
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
	
	@Bean("sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		sqlSessionFactoryBean.setTypeAliasesPackage("tech.mczeno.framework.ssm.entity");
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean("dataSourceTransactionManager")
	public DataSourceTransactionManager dataSourceTransactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
