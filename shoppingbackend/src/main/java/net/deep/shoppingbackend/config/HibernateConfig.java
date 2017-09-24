package net.deep.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "net.deep.shoppingbackend.dto" })
@EnableTransactionManagement
public class HibernateConfig {
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "";

	// DataSource bean
	@Bean
	public DataSource getDataSoruce() {

		BasicDataSource datasoruce = new BasicDataSource();
		// database connection info
		datasoruce.setDriverClassName(DATABASE_DRIVER);
		datasoruce.setUrl(DATABASE_URL);
		datasoruce.setUsername(DATABASE_USERNAME);
		datasoruce.setPassword(DATABASE_PASSWORD);
		return datasoruce;
	}
	// sessionfactory bean

	@Bean
	public SessionFactory getSessionFactory(DataSource datasource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(datasource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.deep.shoppingbackend.dto");
		return builder.buildSessionFactory();
	}

	// all the hibernate properties will be returned in this method
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");

		return properties;
	}

	//transactionManager manger bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

}
