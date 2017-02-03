package com.adu.model;

import java.util.Date;

/**
 * @author yunjie.du
 * @date 2017/1/23 15:19
 */
public class PersonBuilder {
    private String name;
    private int age;
    private Date birthDate;

    public static PersonBuilder newBuilder() {
        return new PersonBuilder();
    }

    public PersonBuilder name(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public PersonBuilder age(int age) {
        this.age = age;
        return this;
    }

    public int getAge() {
        return age;
    }

    public PersonBuilder birthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Person build() {
        return new Person(this);
    }

}
