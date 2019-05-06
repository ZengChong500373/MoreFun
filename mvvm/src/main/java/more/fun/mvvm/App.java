package more.fun.mvvm;

import android.app.Application;

import org.easy.tools.EasySdk;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        EasySdk.init(this);
    }
}
