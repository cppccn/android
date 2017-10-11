package mprimavera.rxfile.model;

public class FileModel {
    private String name;
    private boolean isDirectory;

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
}
