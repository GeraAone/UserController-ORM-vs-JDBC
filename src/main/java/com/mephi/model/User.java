package com.mephi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(schema = "UserSchema", name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private static Long id;

    @Column(name = "name")
    private static String name;

    @Column(name = "lastName")
    private static String lastName;

    @Column(name = "age")
    private static Byte age;

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

    public static Byte getAge() {
        return age;
    }

    public static String getLastName() {
        return lastName;
    }

    public static String getName() {
        return name;
    }
}
