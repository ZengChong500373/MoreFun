package more.fun.mvp.logic;

import java.util.List;

import more.fun.mvp.base.BasePresenter;
import more.fun.mvp.base.BaseResponseView;
import more.fun.mvp.entity.DiscoveryList1;

/**
 * author : jyh
 * date : 2019/4/10
 * qq : 84714581
 * describe :DiscoveryListContract
 */
public interface DiscoveryListContract {

    interface View extends BaseResponseView {
        void onLoadSortSuccess(List<DiscoveryList1> data);

    }


    interface Presenter extends BasePresenter {
        void  init(int position);
    }
}
