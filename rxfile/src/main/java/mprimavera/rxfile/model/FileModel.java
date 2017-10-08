package mprimavera.rxfile.model;

public class FileModel {
    private String name;

    public FileModel() {}

    public FileModel(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
