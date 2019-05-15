package more.fun.mvp.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.easy.tools.Key;
import org.easy.tools.utils.ToastUtils;
import org.easy.ui.StatusControlLayout;
import org.easy.ui.recycler.listener.ItemClickListener;

import more.fun.mvp.App;
import more.fun.mvp.R;
import more.fun.mvp.base.MvpFragment;
import more.fun.mvp.entity.HotList;
import more.fun.mvp.entity.HotTabs;
import more.fun.mvp.logic.HotListContract;
import more.fun.mvp.logic.HotListPresenterImpl;
import more.fun.mvp.ui.adapter.HotListAdapter;


/**
 * author : jyh
 * date : 2019/4/10
 * qq : 84714581
 * describe :
 */
public class HotListFragment extends MvpFragment<HotListPresenterImpl> implements HotListContract.View<HotList> , ItemClickListener {
    StatusControlLayout control_layout;
    RecyclerView recycler;
    HotListAdapter adapter;
    public static HotListFragment newInstance(int position) {
        Bundle args = new Bundle();
        HotListFragment fragment = new HotListFragment();
        args.putInt(Key.POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int setFragmentView() {
        return R.layout.fragment_discovery_hot_list;
    }

    @Override
    public void initViews() {
        control_layout=find(R.id.control_layout);
        recycler=find(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new HotListAdapter();
        adapter.setItemListener(this);
        recycler.setAdapter(adapter);
    }

    @Override
    public void onFirstUserVisible() {
        int current_position = getArguments().getInt(Key.POSITION);
        HotTabs.TabInfoBean.TabBean bean = App.getHotTabs().getTabInfo().getTabList().get(current_position);
        presenter=new HotListPresenterImpl(this);
        presenter.initList(bean.getApiUrl());
    }


    @Override
    public void onLoadSuccess(HotList data) {
        adapter.setData(data.getItemList());
    }


    @Override
    public void hideLoading() {
        super.hideLoading();
        control_layout.hideLoading();
    }

    @Override
    public void showError(String str, int code) {

    }

    @Override
    public void showLoading() {
        super.showLoading();
        control_layout.showLoading();
    }

    @Override
    public void onItemClick(View view, int postion) {
        ToastUtils.getInstance().show("position="+postion);
    }
}
