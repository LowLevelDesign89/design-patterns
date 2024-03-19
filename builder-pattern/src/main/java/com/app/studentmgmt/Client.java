package com.app.studentmgmt;

public class Client {
    public static void main(String[] args) {
        Student enggStudent = createEngineeringStudent();
        Student mbaStudent = createMBAStudents();

        System.out.println("Engineering Student Details: " + enggStudent);
        System.out.println("MBA Student Details: " + mbaStudent);
    }

    private static Student createEngineeringStudent() {
        return new EngineeringStudent()
                .name("John Smith")
                .fathersName("Jim Smith")
                .mothersName("Jena Smith")
                .rollNumber("JS123")
                .subjects()
                .build();
    }

    private static Student createMBAStudents() {
        return new MBAStudent()
                .name("Jenifer Williams")
                .fathersName("Shean Williams")
                .mothersName("Lauren Williams")
                .rollNumber("JW456")
                .subjects()
                .build();
    }
}
