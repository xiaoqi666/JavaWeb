import com.xiaoqi.domain.CustomerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.testng.annotations.Test;

public class Main {


    @Test
    public void test() {
        Configuration configuration = new Configuration();
        Configuration configure = configuration.configure();
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustName("小柒爱");
        customerEntity.setCustLevel("123456");
        customerEntity.setCustIndustry("123456789");
        customerEntity.setCustLinkman("水水");
        session.save(customerEntity);
        transaction.commit();
        session.close();
        sessionFactory.close();
        System.out.println("运行结束");
    }


}
