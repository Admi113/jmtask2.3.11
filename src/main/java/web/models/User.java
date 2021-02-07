package web.models;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")

public class User {
    @Column(name = "name")
    @NotEmpty(message = "shoudnt be empty")
    @Size(min = 2, max = 30, message = "2> Name size >30")
    private String name;

    @Column(name = "surname")
    @NotEmpty(message = "shoudnt be empty")
    @Size(min = 2, max = 50, message = "2> Surname >30")
    private String surname;

    @Column(name = "age")
    //    @Size(min = 0, message = "age shoul be greather than 0")
    private int age;
//    @Email() проверяет через регулярки

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public User() {
    }

    public User(String name, String surname, int age, int id) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
