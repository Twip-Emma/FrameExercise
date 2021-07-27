package com.twip.mybatis.utils;

import com.twip.mybatis.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    @Test
    public void test() throws IOException {
        String resource = "config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession实例，能够直接执行已经映射的sql语句
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            Object[] arg1 = {1};
            Employee employee = openSession.selectOne("com.twip.mybatis.entity.EmployeeMapper.selectEmp", 1);
            System.out.println(employee);
        }finally {
            openSession.close();
        }
    }
}
