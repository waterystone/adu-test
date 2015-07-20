package com.adu.bean;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * @author: yunjie.du
 * @date: 2015/7/20 15:12
 */
public class JsonBean {
    @JsonProperty("ResultCode")
    private int resultCode;
    @JsonProperty("Students")
    private List<Student> studentList;

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

    @Override
    public String toString() {
        return "JsonBean{" + "resultCode=" + resultCode + ", studentList=" + studentList + '}';
    }

    public static class Student {
        @JsonProperty("id")
        private int id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("age")
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
