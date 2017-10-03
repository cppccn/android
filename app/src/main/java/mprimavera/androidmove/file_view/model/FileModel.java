package mprimavera.androidmove.file_view.model;

public class FileModel {
    private String name;

    public FileModel() {}

    public FileModel(String name) {
        this.name = name;
    }

    public void setString(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
