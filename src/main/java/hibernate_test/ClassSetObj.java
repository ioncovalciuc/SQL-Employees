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

public class ClassSetObj {
    public static void main(String[] args) throws SQLException {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeesEntity.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            EmployeesEntity employees1 = new EmployeesEntity("Ion", "Covalciuc", "IT", 1000);
            EmployeesEntity employees6 = new EmployeesEntity("Dan", "Sandu", "IT", 1000);
            session.beginTransaction();
            EmployeesEntity emp = session.get(EmployeesEntity.class,4);
            emp.setSalary(3244);
//            session.createQuery("update EmployeesEntity set salary = 1235"
//                    +" where surname='Dragomir'");
            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }
    }
}
