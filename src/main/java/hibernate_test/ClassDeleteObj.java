package hibernate_test;

import hibernate_test.entity.Employees;
import hibernate_test.entity.EmployeesEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClassDeleteObj {
    public static void main(String[] args) throws SQLException {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeesEntity.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            session.beginTransaction();
            EmployeesEntity emp = session.get(EmployeesEntity.class,6);
            session.delete(emp);
//            session.createQuery("delete EmployeesEntity where surname = 'Popescu'");
            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }
    }
}
