package com.adu.model;

import java.util.Date;

import com.adu.api.common.Stringfy;

public class Person extends Stringfy {
    private static final long serialVersionUID = 4802319003105920366L;
    private String name;
    private int age;
    private Date birthDate;

    public Person() {
        super();
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, Date birthDate) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
    }

    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.getName();
        this.age = personBuilder.getAge();
        this.birthDate = personBuilder.getBirthDate();
    }

    @Override
    public int hashCode() {
        return (this.name + this.age + this.birthDate).hashCode();
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
