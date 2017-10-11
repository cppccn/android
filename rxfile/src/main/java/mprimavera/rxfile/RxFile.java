package mprimavera.rxfile;

import android.os.Environment;
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
                    FileModel model = new FileModel();
                    model.setName(files[i].getName());
                    model.setIsDirectory(files[i].isDirectory());
                    result.add(model);
                }

                emitter.onNext(result);
                emitter.onComplete();
            } catch(Exception e) {
                emitter.onError(e);
            }
        });
    }

    public static Observable<List<FileModel>> listInternal(String path) {
        File rootDirectory = Environment.getRootDirectory();

        if(path == null) {
            return listDirectory(rootDirectory);
        } else {
            String directoryPath = rootDirectory.getAbsolutePath();
            if(!path.startsWith("/")) {
                path = "/" + path;
            }

            File dir = new File(directoryPath + path);
            return listDirectory(dir);
        }
    }
}
