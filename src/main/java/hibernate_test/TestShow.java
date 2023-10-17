package hibernate_test;

import hibernate_test.entity.Employees;
import hibernate_test.entity.EmployeesEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.List;

public class TestShow {
    public static void main(String[] args) throws SQLException {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeesEntity.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            List<Employees> emps = session.createQuery("from Employees ")
                    .getResultList();
            for (Employees e : emps)
                System.out.println(e);
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
