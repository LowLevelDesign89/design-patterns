package com.app.studentmgmt;

import java.util.ArrayList;
import java.util.List;

public class EngineeringStudent extends StudentBuilder {
    @Override
    public StudentBuilder subjects() {
        List<String> subjects = new ArrayList<>();
        subjects.add("Operating Systems");
        subjects.add("Computer Networks");
        subjects.add("Introduction to C");
        this.subjects = subjects;
        return this;
    }
}
