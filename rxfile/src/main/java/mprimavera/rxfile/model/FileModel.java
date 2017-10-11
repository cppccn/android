package mprimavera.rxfile.model;

import java.io.File;

public class FileModel {
    private String name;
    private boolean isDirectory;
    private double size;
    private String path;
    private File file;

    public FileModel() {}

    public FileModel(String name) {
        this.name = name;
    }
    public FileModel(String name, boolean isDirectory) {
        this.name = name;
        this.isDirectory = isDirectory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean isDirectory() {
        return this.isDirectory;
    }

    public void setIsDirectory(boolean isDirectory) {
        this.isDirectory = isDirectory;
    }

    public void setPath(String path) { this.path = path; }
    public String getPath() { return this.path; }

    public void setSize(double size) { this.size = size; }
    public double getSize() { return this.size; }

    public File getFile() { return this.file; }
    public void setFile(File file) { this.file = file; }
}
