package mprimavera.androidmove;

import android.app.Application;

public class MyApplication extends Application implements IApplication {
    private NavigationManager navigationManager;

    public MyApplication() {
        super();
        this.navigationManager = new NavigationManager();
    }

    public NavigationManager getNavigationManager() {
        return this.navigationManager;
    }
}
