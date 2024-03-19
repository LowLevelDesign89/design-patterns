package com.app.studentmgmt;

import java.util.ArrayList;
import java.util.List;

public class MBAStudent extends StudentBuilder{
    @Override
    public StudentBuilder subjects() {
        List<String> subjects = new ArrayList<>();
        subjects.add("Marketing");
        subjects.add("HR");
        subjects.add("Mass Communication");
        this.subjects = subjects;
        return this;
    }
}
