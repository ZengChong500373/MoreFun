package more.fun.mvp.logic;

import io.reactivex.Observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import more.fun.mvp.base.GlobalConstant;
import more.fun.mvp.base.RxUtils;
import more.fun.mvp.entity.HotTabs;
import more.fun.mvp.http.HttpThrowable;
import more.fun.mvp.http.NetWork;

/**
 * author : jyh
 * date : 2019/4/10
 * qq : 84714581
 * describe :
 */
public class HotPresenterImpl implements HotContract.Presenter {
    private Disposable disposable;

    public HotPresenterImpl(HotContract.View view) {
        this.view = view;
    }

    protected HotContract.View<HotTabs> view;

    @Override
    public void detachView() {
        view = null;
        disposable.dispose();
        disposable = null;
    }

    @Override
    public void initTabs() {
        view.showLoading();
        HttpThrowable throwable= HttpThrowable.getInstance();
        throwable.setView(view);
        disposable = getTabs().subscribe(new Consumer<HotTabs>() {
            @Override
            public void accept(HotTabs hotTabs) throws Exception {
                if (hotTabs != null) {
                    view.hideLoading();
                    view.onLoadSuccess(hotTabs);
                } else {
                    view.showError("empty", GlobalConstant.layout_empty);
                }

            }
        },throwable);


    }

    private Observable<HotTabs> getTabs() {
        return NetWork.getInsatance().getMethods().getHotTabs().compose(RxUtils.<HotTabs>commTrans());
    }

}
