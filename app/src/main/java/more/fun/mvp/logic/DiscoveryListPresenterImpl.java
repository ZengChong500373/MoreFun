package more.fun.mvp.logic;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import more.fun.mvp.base.RxUtils;
import more.fun.mvp.entity.DiscoveryList1;
import more.fun.mvp.http.NetWork;

/**
 * author : jyh
 * date : 2019/4/10
 * qq : 84714581
 * describe :
 */
public class DiscoveryListPresenterImpl implements DiscoveryListContract.Presenter {
    private Disposable disposable;

    public DiscoveryListPresenterImpl(DiscoveryListContract.View view) {
        this.view = view;
    }

    protected DiscoveryListContract.View view;

    @Override
    public void detachView() {
        view = null;
        disposable.dispose();
        disposable = null;
    }




    @Override
    public void init(int position) {
        view.showLoading();
        if (position==0){

        }else {
            disposable = getTpye1().subscribe(new Consumer<DiscoveryList1>() {
                @Override
                public void accept(DiscoveryList1 data) throws Exception {
                    if (data != null) {
                        view.hideLoading();
                        Log.e("1","");
                    } else {
                        Log.e("1","");
                    }

                }
            }, new Consumer<Throwable>() {
                @Override
                public void accept(Throwable throwable) throws Exception {
                    Log.e("1","");
                }
            });
        }

    }
    public Observable<DiscoveryList1> getTpye1(){
        return  NetWork.getInsatance().getMethods().getDisCoverList1().compose(RxUtils.<DiscoveryList1>commTrans());
    }
}
