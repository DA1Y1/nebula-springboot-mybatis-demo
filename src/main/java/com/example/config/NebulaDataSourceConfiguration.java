package com.example.config;

import com.mininglamp.nebulamybatis.GraphResultSetIntercept;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 图数据源配置
 *
 * @author Pan BinBin
 * @date 2021/7/27
 */
@Configuration
@MapperScan(basePackages = "com.example.graph.mapper", sqlSessionTemplateRef = "graphSqlSessionTemplate")
public class NebulaDataSourceConfiguration {

    @Bean("graphDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.graph")
    public DataSourceProperties graphDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean("graphDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.graph.hikari")
    public DataSource graphDataSource(@Qualifier("graphDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean("graphJdbcTemplate")
    public JdbcTemplate graphJdbcTemplate(@Qualifier("graphDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean("graphSqlSessionFactory")
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("graphDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:graphmapper/*.xml"));
        factory.setPlugins(new GraphResultSetIntercept());
        return factory.getObject();
    }

    @Bean(name = "graphSqlSessionTemplate")
    public SqlSessionTemplate primarySqlSessionTemplate(@Qualifier("graphSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
