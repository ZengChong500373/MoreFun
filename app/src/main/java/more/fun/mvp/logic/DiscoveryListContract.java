package more.fun.mvp.logic;

import more.fun.mvp.base.BasePresenter;
import more.fun.mvp.base.BaseResponseView;

/**
 * author : jyh
 * date : 2019/4/10
 * qq : 84714581
 * describe :DiscoveryListContract
 */
public interface DiscoveryListContract {

    interface View extends BaseResponseView {

    }


    interface Presenter extends BasePresenter {
        void  init(int position);
    }
}
