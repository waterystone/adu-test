package com.adu.model;

import org.joda.time.DateTime;

import com.adu.api.common.Stringfy;

import java.util.Date;

public class MyPerson extends Stringfy {
    private String name;
    private int age;
    private DateTime birthDate;
    private Date myDate;
    private SubObject myObject;

    public MyPerson() {
    }

    public MyPerson(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public MyPerson(String name, int age, DateTime birthDate) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
    }

    public MyPerson(String name, int age, DateTime birthDate, Date myDate) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.myDate = myDate;
    }

    public MyPerson(String name, int age, DateTime birthDate, Date myDate, SubObject myObject) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.myDate = myDate;
        this.myObject = myObject;
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

    public DateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(DateTime birthDate) {
        this.birthDate = birthDate;
    }

    public Date getMyDate() {
        return myDate;
    }

    public void setMyDate(Date myDate) {
        this.myDate = myDate;
    }

    public SubObject getMyObject() {
        return myObject;
    }

    public void setMyObject(SubObject myObject) {
        this.myObject = myObject;
    }
}
