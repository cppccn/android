package mprimavera.androidmove;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import mprimavera.androidmove.file_view.view.FileView;

public class NavigationManager {
    public NavigationManager() {}

    public void openMainScreen(AppCompatActivity activity) {
        // Create fragment and give it an argument specifying the article it should show
        FileView fileView = new FileView();

        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.add(R.id.fragment_container, fileView);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }
}
