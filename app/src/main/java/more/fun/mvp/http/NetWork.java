package more.fun.mvp.http;


import org.easy.tools.utils.UiUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import more.fun.mvp.base.GlobalConstant;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/4/17.
 */

public class NetWork {
    private static class SingletonHolder {
        private static final NetWork instance = new NetWork();
    }
    private NetWork() {
        initOkhttp();
    }

    public static NetWork getInsatance() {

        return SingletonHolder.instance;
    }
    private static OkHttpClient mOkHttpClient;
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJava2CallAdapterFactory.create();

    private static HttpMethods methods;
    private static void initOkhttp() {
        if (mOkHttpClient == null) {
            synchronized (NetWork.class) {
                if (mOkHttpClient == null) {
                    File mFile = new File(UiUtils.getContext().getCacheDir(), "cache");
                    Cache mCache = new Cache(mFile, 1024 * 1024 * 200);
                    CacheInterceptor cacheInterceptor = new CacheInterceptor();
                    ParameterInterceptor parameterInterceptor=new ParameterInterceptor();

                    HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLogger());//创建拦截对象
                    logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//这一句一定要记得写，否则没有数据输出
                    mOkHttpClient = new OkHttpClient.Builder()
                            .cache(mCache)
                            .addInterceptor(parameterInterceptor)
//                            .addInterceptor(cacheInterceptor)
                            .addInterceptor(logInterceptor)
                            .retryOnConnectionFailure(true)
                            .connectTimeout(15, TimeUnit.SECONDS)
                            .build();
                }
            }
        }
    }

    public  HttpMethods getMethods() {
        if (methods == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(mOkHttpClient)
                    .baseUrl(GlobalConstant.baseUrl)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            methods = retrofit.create(HttpMethods.class);
        }
        return methods;
    }

}
