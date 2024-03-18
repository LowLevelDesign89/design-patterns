package com.app.filesystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
    private List<FileSystem> fileSystems;
    private String name;

    public Directory(String name) {
        this.name = name;
        this.fileSystems = new ArrayList<>();
    }

    public void add(FileSystem fileSystem) {
        fileSystems.add(fileSystem);
    }

    @Override
    public void ls() {
        System.out.println("Current Directory : " + name);
        for(FileSystem fileSystem: fileSystems) {
            fileSystem.ls();
        }
    }
}
