package com.myweb.www.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = {"com.myweb.www"})
@MapperScan(basePackages = {"com.myweb.www.repository"})
public class RootConfig {
	
	@Autowired //inject이랑 같은 의미이다. 사용자가 직접 작성했냐 안했냐 차이
	ApplicationContext applicationContext;
	
	//DB설정
	//log4jdbc-log4j2 라이브러리 사용 시 Driver를 "net.sf.log4jdbc.sql.jdbcapi.DriverSpy"로 사용해야한다.
	
	@Bean //어노테이션에서 Component는 사용자가 직접 만든 메서드, Bean은 만들어져있는 메서드이다.
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		
		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		hikariConfig.setJdbcUrl("jdbc:log4jdbc:mysql://localhost:3306/finalproject");
		hikariConfig.setUsername("springuser");
		hikariConfig.setPassword("mysql");
		hikariConfig.setMinimumIdle(5); //DB에서 최소 유휴 커넥션 개수를 정하는 기능이다.
		
		hikariConfig.setConnectionTestQuery("SELECT now()"); //test 쿼리 체크
		hikariConfig.setPoolName("springHikariCP");
		
		//추가되는 부분
		//내가만든 쿼리문을 보여주는 기능, cashe 사용 여부에 대한 설정이다.
		hikariConfig.addDataSourceProperty("dataSource.cashePrepStmts", "true");
		//mysql 드라이브가 연결 당 cashe할 statement의 수에 관한 설정이다. 기본25, 권장200~500
		hikariConfig.addDataSourceProperty("dataSource.prepStmtCasheSize", "200");
		//catch할 sql 구문의 최대 길이
		hikariConfig.addDataSourceProperty("dataSource.prepStmtCasheSqlLimit", "true");
		//server에서 해당 cashe에 대한 지원을 할것인가 true,false로 지정 (지원받는 설정에 대한 부분 설정)
		hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");
		
		HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
		return hikariDataSource; 
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlFactoryBean = new SqlSessionFactoryBean();
		sqlFactoryBean.setDataSource(dataSource()); //위에서 설정한 hikariConfig DataSource를 담는다.
		sqlFactoryBean.setConfigLocation(
				applicationContext.getResource("classpath:/MybatisConfig.xml")); //설정사항에 관한 경로 설정
		sqlFactoryBean.setMapperLocations(
				applicationContext.getResources("classpath:/mappers/*.xml"));
		return (SqlSessionFactory)sqlFactoryBean.getObject(); //자료형 맞춰서 리턴한다.
	}
}
