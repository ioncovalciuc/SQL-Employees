package hibernate_test.entity;

import lombok.*;

import javax.persistence.*;


@Data
@ToString
@NoArgsConstructor
@Entity
@Table(name = "employees", schema = "public")
public class Employees {
    @Id

    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "departament")
    private String department;
    @Column(name = "salary")
    private int salary;

    public Employees(String name, String surname, String department, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }
}
