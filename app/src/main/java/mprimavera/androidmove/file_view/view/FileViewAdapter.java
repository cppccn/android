package mprimavera.androidmove.file_view.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import mprimavera.androidmove.R;
import mprimavera.rxfile.model.FileModel;

public class FileViewAdapter extends ArrayAdapter<FileModel> {
    public FileViewAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public FileViewAdapter(Context context, int resource, List<FileModel> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.file_view_item_row, null);
        }

        FileModel file = getItem(position);

        if (file != null) {
            TextView fileName = v.findViewById(R.id.fileName);
            fileName.setText(file.getName());
        }

        return v;
    }

}