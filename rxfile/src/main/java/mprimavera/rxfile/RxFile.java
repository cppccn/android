package mprimavera.rxfile;

import android.os.Environment;
import android.util.Log;

import java.io.File;

public class RxFile {
    public void list() {
        String path = Environment.getExternalStorageDirectory().toString();

        Log.d("Files", "Path: " + path);
        File directory = new File(path);

        File[] files = directory.listFiles();

        Log.d("Files", "Size: "+ files.length);
        for (int i = 0; i < files.length; i++) {
            Log.d("Files", "FileName:" + files[i].getName());
        }
    }
}
