package com.xiaoqi.test;

import com.xiaoqi.utils.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import java.util.List;

/**
 * 原生sql查询
 */
public class Main_sql {
    @Test
    public void test() {
        Session session = HibernateUtil.opneSession();
        Transaction transaction = session.beginTransaction();
        //创建sql查询对象
        String sql = "select * from customer";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        List list = sqlQuery.list();//查询结果每行是个Object[]数组
        System.out.println(list.get(0));
        transaction.commit();
        session.close();
    }


}
