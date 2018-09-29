package com.xiaoqi.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 数据库工具类
 */
public class HibernateUtil {

    static {
        Configuration configuration = new Configuration();
        Configuration configure = configuration.configure();
        sessionFactory = configure.buildSessionFactory();
    }

    private static SessionFactory sessionFactory;

    public static Session opneSession() {
        Session session = sessionFactory.openSession();
        return session;
    }

    public static Session getCurrentSession() {
        Session session = sessionFactory.getCurrentSession();
        return session;
    }


}
