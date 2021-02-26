package stud;

import org.hibernate.annotations.GenericGenerator;

import javax.enterprise.context.RequestScoped;
import javax.persistence.*;
import java.lang.annotation.ElementType;

@Entity
@Table(name = "students")
public class Students {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "age")
    int age;

    public Students() {
    }

    public Students(String name, int age) {
        this.name = name;
        this.age=age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
