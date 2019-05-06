package more.fun.mvp.base;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * author : jyh
 * date : 2019-04-18
 * qq : 84714581
 * https://github.com/ZengChong500373
 * describe :
 */
public class RxUtils {
    public static <T> ObservableTransformer<T, T> commTrans() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());

            }
        };
    }
}
