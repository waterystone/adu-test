package com.adu.bean;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author: yunjie.du
 * @date: 2015/7/20 14:51
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlRootElement(name = "GetStudentsResult")
public class XMLBean {
    @XmlElement(name = "ResultCode")
    private int resultCode;
    @XmlElementWrapper(name = "Students")
    @XmlElement(name = "Student")
    private List<Student> studentList;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        return "XMLBean{" + "resultCode=" + resultCode + ", studentList=" + studentList + '}';
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @XmlAccessorType(value = XmlAccessType.FIELD)
    public static class Student {
        @XmlAttribute(name = "id")
        private int id;
        @XmlElement(name = "name")
        private String name;
        @XmlElement(name = "age")
        private int age;

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

        @Override
        public String toString() {
            return "Student{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
        }
    }
}
