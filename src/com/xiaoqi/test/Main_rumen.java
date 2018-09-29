package com.xiaoqi.test;

import com.xiaoqi.domain.CustomerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.Test;

public class Main_rumen {

    @Test
    public void test() {

       /*
       Configuration功能:配置加载类,用于加载配置,orm元数据加载
       SessionFactory功能:用于创建数据库操作独享session对象的工厂,简单来说,功能就一个,创建session对象,
                      注意:
                            1.0 SessionFactory负责保存和使用所有配置信息,消耗内存非常大
                            2.0 SessionFactory属于线程安全的对象设计
                      结论:保证在web项目中只创建一个SessionFactory对象
       */
        // 创建,调用空参
        Configuration configuration = new Configuration();
        //读取配置文件
        Configuration configure = configuration.configure();
         /*
                获得一个与线程绑定的session对象
                Session currentSession = sessionFactory.getCurrentSession();

         */
        //根据配置,创建SessionFactory
        SessionFactory sessionFactory = configure.buildSessionFactory();
        //打开一个新的session对象
        /*
         Session:表达hibernate框架与数据库之间的连接(会话),
                是hibernate操作数据库的核心对象
                JDBC年代还可以完成对数据库的增删改查操作
         */
        Session session = sessionFactory.openSession();
        /*
                获得数据库操作事务的对象,仅仅获得,不开启事务
                Transaction transaction = session.getTransaction();
                transaction.begin();//开启事务
                transaction.commit();//事务提交
                transaction.rollback();//事务回滚
         */
        // 获得数据库操作事务的对象,顺便开启(一句话,多干事,建议使用)
        Transaction transaction = session.beginTransaction();
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustName("小柒爱");
        customerEntity.setCustLevel("123456");
        customerEntity.setCustIndustry("123456789");
        customerEntity.setCustLinkman("水水");
        //插入
        // session.save(customerEntity);

        //根据id进行查询
//        CustomerEntity o = (CustomerEntity) session.get(CustomerEntity.class, 4L/*实体的数据类型*/);
//        System.out.println("查询结果:---------------"+o.getCustName());

        //修改
        //先获得id为4的对象
//        CustomerEntity cus = (CustomerEntity) session.get(CustomerEntity.class, 5L);
//        cus.setCustName("小明");
//        //进行数据更新
//        session.update(cus);

        //删除,先获得对象,再删除
//        CustomerEntity cus = (CustomerEntity) session.get(CustomerEntity.class, 4L);
//        session.delete(cus);



        //事务提交
        transaction.commit();
        //释放资源
        session.close();
        sessionFactory.close();
        System.out.println("运行结束");
    }
}
