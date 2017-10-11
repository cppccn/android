package mprimavera.rxfile;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.Observable;
import mprimavera.rxfile.model.FileModel;

public class RxFile {
    private static class NotDirectoryException extends Exception {}
    public static Observable<List<FileModel>> listDirectory(File directory) {
        return Observable.create(emitter -> {
            try {
                Log.d("TEST", "Trying to browse : " + directory.getAbsolutePath());
                if(!directory.isDirectory()) {
                    emitter.onError(new NotDirectoryException());
                }

                File[] files = directory.listFiles();
                if(files == null) {
                    emitter.onNext(new ArrayList<>());
                    emitter.onComplete();
                    return;
                }

                List<FileModel> result = new ArrayList<>();
                for(int i = 0; i < files.length; i++) {
                    File file = files[i];
                    FileModel model = new FileModel();
                    model.setName(file.getName());

                    boolean isDirectory = file.isDirectory();
                    model.setIsDirectory(isDirectory);

                    if(!isDirectory) {
                        double size = file.length() / 1024.0;
                        model.setSize(size);
                    }

                    model.setPath(file.getAbsolutePath());
                    model.setFile(file);

                    result.add(model);
                }

                emitter.onNext(result);
                emitter.onComplete();
            } catch(Exception e) {
                emitter.onError(e);
            }
        });
    }

    public static Observable<List<FileModel>> listFiles(File directory) {
        return listDirectory(directory);
    }

    public static Observable<List<FileModel>> listInternal(String path) {
        File rootDirectory = Environment.getRootDirectory();

        if(path == null) {
            return listDirectory(rootDirectory);
        } else {
            if(!path.startsWith("/")) {
                path = "/" + path;
            }

            File dir = new File(path);
            return listDirectory(dir);
        }
    }
}
