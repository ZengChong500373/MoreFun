package more.fun.mvvm.base;


import more.fun.mvvm.base.mvp.BaseView;

public interface RefreshMoreView<T> extends BaseView {
    void  onloadheadSuccess(T t);
    void  onloadMoreSuccess(T t);

}
