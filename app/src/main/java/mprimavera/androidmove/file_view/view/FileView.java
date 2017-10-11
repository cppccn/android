package mprimavera.androidmove.file_view.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import mprimavera.androidmove.R;
import mprimavera.rxfile.RxFile;

public class FileView extends Fragment {
    private LinearLayout mView;
    private ListView mFileListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = (LinearLayout) inflater.inflate(R.layout.frag_file_view, container, false);

        mFileListView = mView.findViewById(R.id.listView);
        this.listFiles();
        return mView;
    }

    public void listFiles() {
        RxFile.listInternal(null)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError(error -> {})
            .flatMap(fileModels -> Observable.just(Tools.orderFileModels(fileModels)))
            .subscribe(fileModels -> {
                FileViewAdapter fileViewAdapter = new FileViewAdapter(getContext(), R.layout.file_view_item_row, fileModels);
                mFileListView.setAdapter(fileViewAdapter);
            });
    }
}