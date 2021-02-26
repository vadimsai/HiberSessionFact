package stud;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import sun.misc.Service;

public class M {
    public static void main(String[] args) {
        StandardServiceRegistry registry=new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory=new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session=sessionFactory.openSession();


        session.beginTransaction();
        session.save(new Students("SAI",777));
        session.getTransaction().commit();
    }

}
