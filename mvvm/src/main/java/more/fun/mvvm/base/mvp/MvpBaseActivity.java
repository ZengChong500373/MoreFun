package more.fun.mvvm.base.mvp;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.easy.tools.utils.ToastUtils;


/**
 * Created by jyh on 2018/4/25.
 */

public abstract class MvpBaseActivity<T extends ViewDataBinding,P extends BasePresenter> extends AppCompatActivity implements BaseView {
    protected P presenter;
    public T binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=   DataBindingUtil.setContentView(this, setLayout());
        presenter = initPresenter();
        initView();
        initData();
    }

    // 布局资源ID
    protected abstract int setLayout();

    // 初始化P层
    protected abstract P initPresenter();

    protected void initView() {
    }

    protected void initData() {
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMsg(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.getInstance().show(msg);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }
}
