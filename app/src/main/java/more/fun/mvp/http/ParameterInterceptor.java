package more.fun.mvp.http;

import android.os.Build;

import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * author : jyh
 * date : 2019-04-18
 * qq : 84714581
 * https://github.com/ZengChong500373
 * describe : 设置公共参数
 */
public class ParameterInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request;
        Request originalRequest = chain.request();
        HttpUrl  modifiedUrl=originalRequest.url().newBuilder()
                .addQueryParameter("udid", "d2807c895f0348a180148c9dfa6f2feeac0781b5")
                .addQueryParameter("deviceModel", Build.MODEL.trim())
                .build();
        request = originalRequest.newBuilder().url(modifiedUrl).build();
        return chain.proceed(request);
    }
}
