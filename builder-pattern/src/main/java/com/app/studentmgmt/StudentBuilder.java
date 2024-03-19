package com.app.studentmgmt;

import java.util.List;

public abstract class StudentBuilder {
    String rollNum;
    String name;
    String fathersName;
    String mothersName;
    List<String> subjects;

    public StudentBuilder rollNumber(String rollNum) {
        this.rollNum = rollNum;
        return this;
    }

    public StudentBuilder name(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder fathersName(String fathersName) {
        this.fathersName = fathersName;
        return this;
    }

    public StudentBuilder mothersName(String mothersName) {
        this.mothersName = mothersName;
        return this;
    }

    public abstract StudentBuilder subjects();

    public Student build() {
        return new Student(this);
    }
}
