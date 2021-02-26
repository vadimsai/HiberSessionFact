import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import stud.Students;

import javax.annotation.Resource;
import javax.persistence.*;
import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.*;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

  StandardServiceRegistry registry=new StandardServiceRegistryBuilder().configure().build();
  SessionFactory sessionFactory=new MetadataSources(registry).buildMetadata().buildSessionFactory();
  Session session=sessionFactory.openSession();

  Students students=new Students("SAIIII",777);



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      session.beginTransaction();
      session.save(students);
      session.getTransaction().commit();
      response.getWriter().write(String.valueOf(students));




    }
}
