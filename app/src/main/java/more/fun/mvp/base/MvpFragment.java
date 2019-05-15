package more.fun.mvp.base;

import org.easy.tools.utils.ToastUtils;

/**
 * author : jyh
 * date : 2019-04-18
 * qq : 84714581
 * https://github.com/ZengChong500373
 * describe :
 */
public abstract class MvpFragment<P extends BasePresenter>  extends LazyFragment implements BaseResponseView{
    protected P presenter;
    @Override
    public void onFirstUserVisible() {

    }
    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String str, int code) {
        ToastUtils.getInstance().show(str);
    }
}
