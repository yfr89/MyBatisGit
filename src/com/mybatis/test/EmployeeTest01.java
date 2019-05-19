package com.mybatis.test;
import com.mybatis.bean.Employee;
import com.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.*;
//测试类
public class EmployeeTest01 {
    public static void main(String args[]) throws Exception{
        String resource = "mybatis-config.xml";
        //输入字符流
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory ssFactory = new SqlSessionFactoryBuilder().build(reader);
        //使用openSession( )方法的时候，若参数不给，或参数为false,表示事务不自动提交
        //若openSession()参数为true的话，则表示事务会自动提交
        SqlSession session=ssFactory.openSession();
        /*
          selectOne()方法参数是Object类型，不安全
           下面的写法不建议使用
        Employee employee=(Employee)session.selectOne("com.mybatis.dao.EmployeeMapper.getEmpById",1);
        System.out.println("emp= "+employee);
         */
        /*
         接口编程
         */
        EmployeeMapper emap=(EmployeeMapper)session.getMapper(com.mybatis.dao.EmployeeMapper.class);
        Employee emp=new Employee();
        emp.setId(1);
        Employee employee=emap.getEmpById(emp);
        System.out.println("结果为: "+employee);
    }
}

