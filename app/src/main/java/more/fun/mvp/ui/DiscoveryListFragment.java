package more.fun.mvp.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.easy.tools.Key;
import org.easy.ui.StatusControlLayout;
import org.easy.ui.recycler.listener.ItemClickListener;

import more.fun.mvp.R;
import more.fun.mvp.base.LazyFragment;
import more.fun.mvp.base.MvpFragment;
import more.fun.mvp.logic.DiscoveryListContract;
import more.fun.mvp.logic.DiscoveryListPresenterImpl;
import more.fun.mvp.ui.adapter.DiscoveryListAdapter;
import more.fun.mvp.ui.adapter.HotListAdapter;

/**
 * author : jyh
 * date : 2019/4/10
 * qq : 84714581
 * describe :
 */
public class DiscoveryListFragment extends MvpFragment<DiscoveryListPresenterImpl> implements DiscoveryListContract.View , ItemClickListener {
    int current_position;
    StatusControlLayout control_layout;
    RecyclerView recycler;
    DiscoveryListAdapter adapter;
    public static DiscoveryListFragment newInstance(int position) {
        Bundle args = new Bundle();
        DiscoveryListFragment fragment = new DiscoveryListFragment();
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
        adapter=new DiscoveryListAdapter();
        adapter.setItemListener(this);
        recycler.setAdapter(adapter);
    }

    @Override
    public void onFirstUserVisible() {
        current_position = getArguments().getInt(Key.POSITION);
        presenter=new DiscoveryListPresenterImpl(this);
        presenter.init(current_position);
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        control_layout.hideLoading();
    }

    @Override
    public void showLoading() {
        super.showLoading();
        control_layout.showLoading();
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void onItemClick(View view, int postion) {

    }
}
