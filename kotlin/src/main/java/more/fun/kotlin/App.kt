package more.`fun`.kotlin

import android.app.Application
import org.easy.tools.EasySdk

class App : Application(){
    override fun onCreate() {
        super.onCreate()
        EasySdk.init(this);
    }
}