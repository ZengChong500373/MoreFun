package more.fun.mvp.http;

import android.util.Log;

import okhttp3.logging.HttpLoggingInterceptor;

public class HttpLogger implements HttpLoggingInterceptor.Logger  {
    @Override
    public void log(String message) {
        Log.e("HttpLogInfo", message);//okHttp的详细日志会打印出来
    }
}
