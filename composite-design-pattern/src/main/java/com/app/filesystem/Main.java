package com.app.filesystem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<FileSystem> fileSystems = new ArrayList<>();
        FileSystem fileSystem1 = new File("a.txt");
        Directory dir1 = new Directory("personal");
        dir1.add(fileSystem1);
        Directory dir2 = new Directory("Documents");
        dir2.add(dir1);
        FileSystem fs2= new File("payslip.pdf");
        dir2.add(fs2);

        //fileSystems.add(dir2);

        FileSystem fs3 = new File("resume.pdf");
        fileSystems.add(fs3);

        Directory dir3 = new Directory("projects");
        FileSystem fs4 = new File("twosum.java");
        dir3.add(fs4);

        //fileSystems.add(dir3);

        Directory root = new Directory("root");
        root.add(dir2);
        root.add(dir3);

        root.ls();
    }
}
