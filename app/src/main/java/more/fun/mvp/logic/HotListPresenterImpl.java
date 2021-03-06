package more.fun.mvp.logic;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import io.reactivex.functions.Consumer;
import more.fun.mvp.base.GlobalConstant;
import more.fun.mvp.base.RxUtils;
import more.fun.mvp.entity.HotList;
import more.fun.mvp.http.HttpThrowable;
import more.fun.mvp.http.NetWork;

/**
 * author : jyh
 * date : 2019/4/10
 * qq : 84714581
 * describe :
 */
public class HotListPresenterImpl implements HotListContract.Presenter {
    private Disposable disposable;
    public HotListPresenterImpl(HotListContract.View view) {
        this.view = view;
    }

   protected HotListContract.View<HotList> view;
    @Override
    public void detachView() {
        view=null;
        disposable.dispose();
        disposable=null;
    }

    @Override
    public void initList(String str) {
        view.showLoading();
        view.showLoading();
        HttpThrowable throwable= HttpThrowable.getInstance();
        throwable.setView(view);
        disposable = getlist(str).subscribe(new Consumer<HotList>() {
            @Override
            public void accept(HotList data) throws Exception {
                if (data != null) {
                    view.hideLoading();
                    view.onLoadSuccess(data);
                } else {
                    view.showError("empty", GlobalConstant.layout_empty);
                }

            }
        },throwable);

    }

    private Observable<HotList> getlist(String str){
      return  NetWork.getInsatance().getMethods().getHotList(str).compose(RxUtils.<HotList>commTrans());
    }


}
