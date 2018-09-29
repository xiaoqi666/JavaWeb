package com.xiaoqi.test;

import com.xiaoqi.domain.CustomerEntity;
import com.xiaoqi.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import java.util.List;

public class Mian2_hql {

    @Test
    //查询全部
    public void test() {
        Session session = HibernateUtil.opneSession();
        Transaction transaction = session.beginTransaction();
        /***
         * HQL 进行查询
         * 如果有两个CustomerEntity,则写完整类名
         */
        // String hql = "from com.xiaoqi.domain.CustomerEntity";
        String hql = "from CustomerEntity";
        //根据hql创建查询对象
        Query query = session.createQuery(hql);
        //根据查询对象获取查询结果,预测查询结果,是列表还是唯一
        List<CustomerEntity> list = query.list();//返回list结果
        //  Object o = query.uniqueResult();//接收唯一结果
        System.out.println(list.get(0));
        transaction.commit();
        session.close();
    }

    @Test
    //条件查询
    //HQL语句中,不能出现任何数据库相关的信息
    public void test1() {
        Session session = HibernateUtil.opneSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from CustomerEntity where custId = 6";
        //根据hql创建查询对象
        Query query = session.createQuery(hql);
        Object o = query.uniqueResult();//接收唯一结果
        System.out.println(o);
        transaction.commit();
        session.close();
    }

    @Test
    //条件查询
    //问号占位符的使用
    public void test2() {
        Session session = HibernateUtil.opneSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from CustomerEntity where custId = ?";
        //根据hql创建查询对象
        Query query = session.createQuery(hql);
        //设置占位符属性
        query.setLong(0, 5L);//jdbc 从1开始,HQL从0开始
        Object o = query.uniqueResult();//接收唯一结果
        System.out.println(o);
        transaction.commit();
        session.close();
    }

    @Test
    //条件查询
    //命名占位符
    public void test3() {
        Session session = HibernateUtil.opneSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from CustomerEntity where custId = :abc";
        //根据hql创建查询对象
        Query query = session.createQuery(hql);
        query.setParameter("abc", 5L);
        Object o = query.uniqueResult();//接收唯一结果
        System.out.println(o);
        transaction.commit();
        session.close();
    }

    @Test
    //分页查询==limit 1,2
    public void test4() {
        Session session = HibernateUtil.opneSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from CustomerEntity";
        //根据hql创建查询对象
        Query query = session.createQuery(hql);
        //设置分页信息
        query.setFirstResult(0);
        query.setFirstResult(1);
        List<CustomerEntity> list = query.list();
        System.out.println(list.get(0));
        transaction.commit();
        session.close();
    }


}
