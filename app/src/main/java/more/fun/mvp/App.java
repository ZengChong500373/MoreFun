package more.fun.mvp;

import android.app.Application;

import org.easy.tools.EasySdk;

import more.fun.mvp.entity.HotTabs;

public class App extends Application {
    public static HotTabs getHotTabs() {
        return hotTabs;
    }

    public static void setHotTabs(HotTabs hotTabs) {
        App.hotTabs = hotTabs;
    }

    private static HotTabs hotTabs=null;
    @Override
    public void onCreate() {
        super.onCreate();
        EasySdk.init(this);
    }
}
