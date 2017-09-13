package com.adu.model;

import java.util.Date;

import com.adu.api.common.Stringfy;

public class MyPerson extends Stringfy {
    private static final long serialVersionUID = 8112690830881563910L;
    private String name;
    private int age;
    private Date birthDate;

    public MyPerson() {
    }

    public MyPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public MyPerson(String name, int age, Date birthDate) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
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
