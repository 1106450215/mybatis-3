/**
 *    Copyright 2009-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.mybatis.test.chapter2;


import com.mybatis.test.chapter2.mapper.PersonMapper;
import com.mybatis.test.chapter2.entity.Person;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: liy
 * @datetime: 2021/12/14 10:07
 * @description: 使用XML文件获取SqlSessionFactory
 */
public class SqlSessionFactoryTest {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        try {
            // 将配置文件读取形成文件输入流
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            System.out.println(sessionFactory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过编程实现SqlSessionFactory的创建
     *
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        // 数据库连接池
        PooledDataSource pooledDataSource = new PooledDataSource();
        pooledDataSource.setDriver("com.mysql.cj.jdbc.Driver");
        pooledDataSource.setUrl("jdbc:mysql://106.54.180.115:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false");
        pooledDataSource.setUsername("root");
        pooledDataSource.setPassword("Ly123456!");
        // 构建数据库事务
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        // 构建数据库运行环境
        Environment environment = new Environment("development", transactionFactory, pooledDataSource);
        // 构建Configuration对象
        Configuration configuration = new Configuration(environment);
        // 注册mybatis的上下文别名
        configuration.getTypeAliasRegistry().registerAliases("person", Person.class);
        // 注册映射器
        configuration.addMapper(PersonMapper.class);
        // 返回SqlSessionFactory
        return new SqlSessionFactoryBuilder().build(configuration);
    }
}
