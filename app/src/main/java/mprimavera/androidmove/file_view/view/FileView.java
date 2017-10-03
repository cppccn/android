package mprimavera.androidmove.file_view.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import mprimavera.androidmove.R;
import mprimavera.androidmove.file_view.model.FileModel;

public class FileView extends Fragment {
    private LinearLayout mView;
    private ListView mListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = (LinearLayout) inflater.inflate(R.layout.frag_file_view, container, false);

        ListView fileListView = mView.findViewById(R.id.listView);

        List<FileModel> files = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            files.add(new FileModel("Test file -- 200 Mb"));
        }

        FileViewAdapter fileViewAdapter = new FileViewAdapter(getContext(), R.layout.file_view_item_row, files);
        fileListView.setAdapter(fileViewAdapter);
        return mView;
    }
}