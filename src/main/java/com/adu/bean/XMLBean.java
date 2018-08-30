package com.adu.bean;

import com.adu.api.common.Stringfy;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author: yunjie.du
 * @date: 2015/7/20 14:51
 */
@XmlAccessorType(value = XmlAccessType.FIELD)
@XmlRootElement(name = "GetStudentsResult")
public class XMLBean extends Stringfy {
    @XmlElement(name = "ResultCode")
    private int resultCode;
    @XmlElementWrapper(name = "Students")
    @XmlElement(name = "Student")
    private List<Student> studentList;

    public XMLBean() {
    }

    public XMLBean(int resultCode, List<Student> studentList) {
        this.resultCode = resultCode;
        this.studentList = studentList;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @XmlAccessorType(value = XmlAccessType.FIELD)
    public static class Student extends Stringfy {
        @XmlAttribute(name = "id")
        private int id;
        @XmlElement(name = "name")
        private String name;
        @XmlElement(name = "age")
        private int age;

        public Student() {
        }

        public Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
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

    }
}
