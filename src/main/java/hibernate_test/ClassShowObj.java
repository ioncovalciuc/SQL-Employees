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

public class ClassShowObj {
    public static void main(String[] args) throws SQLException {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeesEntity.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            EmployeesEntity employees1 = new EmployeesEntity("Ion", "Covalciuc", "IT", 1000);
            EmployeesEntity employees2 = new EmployeesEntity("Dan", "Covalciuc", "IT", 1000);
            int myID = employees2.getId();
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employees emp = session.get(Employees.class,myID);
            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }
    }
}
