package com.mephi.model;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Table(schema = "userschema", name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "age")
    private Byte age;

    public User(String name, String lastName, Byte age)
    {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
    public Long getId()
    {
        return id;
    }

    public Byte getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }
}
