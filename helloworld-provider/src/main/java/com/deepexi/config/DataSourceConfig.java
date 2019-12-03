package com.deepexi.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 描述。
 * <p>
 * <br>==========================
 * <br> 公司：滴普科技
 * <br> 开发：hudong@deepexi.com
 * <br> 版本：1.0
 * <br> 创建时间：2018/5/2 10:06
 * <br>==========================
 */
@Configuration
@MapperScan("com.deepexi.mapper")
public class DataSourceConfig {

    @Bean(name = "dataSource", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    // 配置事物管理器
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    /**
     * 這個是原生的數據源初始化配置 使用這個配置初始化對接mybaits plus 會出現mybaits plus自帶的方法不能使用 自定義的方法可以使用
     * 修改前
     * @param dataSource
     * @return
     * @throws Exception
     */
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        return sessionFactory.getObject();
//    }

    /**
     * 這個是mybaits plus 使用的數據源初始化配置 這個就沒有上述的問題
     * 修改后
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean factory = new MybatisSqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        return factory.getObject();
}
    /**
     * mybatis-plus 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }

}