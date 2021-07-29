package com.twip.mybatis.utils;

import com.twip.mybatis.dao.EmployeeAnnotation;
import com.twip.mybatis.dao.EmployeeMapper;
import com.twip.mybatis.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {

    public SqlSessionFactory getSqlSessionFactory() throws IOException{
        String resource = "config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @Test
    public void test() throws IOException {
        //最原始方法测试
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

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

    @Test
    public void test2()throws IOException{
        //动态绑定测试（自动生成代理类）

        //1.获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        //2.获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        //3.获取接口的实现类对象
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmpById(1);
            System.out.println(employee);
        }finally {
            openSession.close();
        }

    }

    @Test
    public void test3()throws IOException{
        //在接口内进行注解的sql语句测试

        //1.获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        //2.获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();

        //3.获取接口的实现类对象
        try {
            EmployeeAnnotation mapper = openSession.getMapper(EmployeeAnnotation.class);
            Employee employee = mapper.getEmpById(1);
            System.out.println(employee);
        }finally {
            openSession.close();
        }

    }
}
