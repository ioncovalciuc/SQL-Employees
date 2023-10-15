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

public class ClassObjectAdd {
    public static void main(String[] args) throws SQLException {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeesEntity.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            EmployeesEntity employees1 = new EmployeesEntity("Ion", "Covalciuc", "IT", 1000);

            session.beginTransaction();
            session.save(employees1);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
