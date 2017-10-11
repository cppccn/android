package mprimavera.androidmove.file_view.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mprimavera.rxfile.model.FileModel;

public class Tools {
    public static List<FileModel> orderFileModels(List<FileModel> fileModels) {
        List<FileModel> dirs = new ArrayList<>();
        List<FileModel> files = new ArrayList<>();
        List<FileModel> result = new ArrayList<>();

        for (FileModel f : fileModels) {
            if (f.isDirectory()) dirs.add(f);
            else files.add(f);
        }

        // Order both Dirs and Files lists alphabetically
        Collections.sort(dirs, (file1, file2) -> file1.getName().compareToIgnoreCase(file2.getName()));
        Collections.sort(files, (file1, file2) -> file1.getName().compareToIgnoreCase(file2.getName()));

        result.addAll(dirs);
        result.addAll(files);
        return result;
    }
}
