package com.app.studentmgmt;

import java.util.List;

public class Student {
    private String rollNum;
    private String name;
    private String fathersName;
    private String mothersName;
    private List<String> subjects;

    public Student(StudentBuilder studentBuilder) {
        this.name = studentBuilder.name;
        this.fathersName = studentBuilder.fathersName;
        this.mothersName = studentBuilder.mothersName;
        this.rollNum = studentBuilder.rollNum;
        this.subjects = studentBuilder.subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNum='" + rollNum + '\'' +
                ", name='" + name + '\'' +
                ", fathersName='" + fathersName + '\'' +
                ", mothersName='" + mothersName + '\'' +
                ", subjects=" + subjects +
                '}';
    }

    public String getRollNum() {
        return rollNum;
    }

    public String getName() {
        return name;
    }

    public String getFathersName() {
        return fathersName;
    }

    public String getMothersName() {
        return mothersName;
    }

    public List<String> getSubjects() {
        return subjects;
    }
}
