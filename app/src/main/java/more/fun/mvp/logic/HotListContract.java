package more.fun.mvp.logic;

import more.fun.mvp.base.BasePresenter;
import more.fun.mvp.base.BaseResponseView;

/**
 * author : jyh
 * date : 2019/4/10
 * qq : 84714581
 * describe :
 */
public interface HotListContract {

    interface View<T> extends BaseResponseView {
        void onLoadSuccess(T t);
    }


    interface Presenter extends BasePresenter {
        void  initList(String url);
    }
}
