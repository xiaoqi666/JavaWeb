package com.xiaoqi.test;

import com.xiaoqi.domain.CustomerEntity;
import com.xiaoqi.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.testng.annotations.Test;

/**
 * Hibernate自创的无语句查询
 */
public class Main_Criteria {

    @Test
    public void test() {
        Session session = HibernateUtil.opneSession();
        Transaction transaction = session.beginTransaction();
        //查询所有
        //创建critteria对象
        Criteria criteria = session.createCriteria(CustomerEntity.class);
        //添加查询条件
        /*数据库中所有的条件类Restrictions*/
        criteria.add(Restrictions.eq("custId"/*对象的属性名,不是列名*/, 5L));
//        criteria.setFirstResult();
//        criteria.setMaxResults();
//        criteria.setProjection(Projections.rowCount());//是Projections,不是Projection


        Object o = criteria.uniqueResult();
        System.out.println(o);
        //添加查询参数
        transaction.commit();
        session.close();
    }


}
