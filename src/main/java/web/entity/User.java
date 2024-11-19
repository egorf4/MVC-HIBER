package web.entity;

import javax.persistence.*;

@Entity
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column (name = "name")
    private String name;

    @Column (name = "age")
    private int age;

    @Column(name = "surname")
    private String surname;

    public String getSurname() {
        return surname;
    }

    public User(int id, String name, int age, String surname) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.surname = surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public User() {
    }


}
