package mprimavera.androidmove.file_view.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import mprimavera.androidmove.R;
import mprimavera.rxfile.model.FileModel;

public class FileViewAdapter extends ArrayAdapter<FileModel> {
    public static interface OnFileClicked {
        void clickedOn(FileModel file);
    }

    private OnFileClicked onFileClicked;

    public FileViewAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public FileViewAdapter(Context context, int resource, List<FileModel> items) {
        super(context, resource, items);
    }

    public void setClickListener(OnFileClicked onFileClicked) {
        this.onFileClicked = onFileClicked;
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
            LinearLayout mainLayout = v.findViewById(R.id.mainLayout);

            mainLayout.setOnClickListener(view -> {
                onFileClicked.clickedOn(file);
            });

            TextView fileName = v.findViewById(R.id.fileName);
            fileName.setText(file.getName());

            ImageView icon = v.findViewById(R.id.icon);
            if(file.isDirectory()) {
                icon.setImageResource(R.drawable.ic_folder_black_24px);
            } else icon.setImageResource(R.drawable.ic_insert_drive_file_black_24px);

            TextView sizeView = v.findViewById(R.id.size);
            double size = file.getSize();
            String sizeText;
            if(size >= 1024.0) {
                size /= 1024.0;
                sizeText = String.format("%.2f Mb", size);
            } else {
                sizeText = String.format("%.2f Kb", size);
            }

            sizeView.setText(sizeText);
        }

        return v;
    }

}