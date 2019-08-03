package more.fun.mvp.ui.fragment;

import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import org.easy.tools.Key;
import org.easy.tools.utils.UiUtils;
import org.easy.ui.StatusControlLayout;
import org.easy.ui.recycler.RxRecyclerViewDividerTool;
import org.easy.ui.recycler.listener.ItemClickListener;

import java.util.List;

import more.fun.mvp.R;
import more.fun.mvp.base.GlobalConstant;
import more.fun.mvp.base.MvpFragment;
import more.fun.mvp.entity.DiscoveryList1;
import more.fun.mvp.logic.DiscoveryListContract;
import more.fun.mvp.logic.DiscoveryListPresenterImpl;
import more.fun.mvp.ui.adapter.DiscoveryListAdapter;

/**
 * author : jyh
 * date : 2019/4/10
 * qq : 84714581
 * describe :
 */
public class DiscoveryListFragment extends MvpFragment<DiscoveryListPresenterImpl> implements DiscoveryListContract.View, ItemClickListener {
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
        control_layout = find(R.id.control_layout);
        recycler = find(R.id.recycler);
        recycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recycler.addItemDecoration(new RxRecyclerViewDividerTool(UiUtils.dp2px(2),UiUtils.dp2px(2), UiUtils.dp2px(2),UiUtils.dp2px(2)));
        adapter = new DiscoveryListAdapter();
        adapter.setItemListener(this);
        recycler.setAdapter(adapter);
    }

    @Override
    public void onFirstUserVisible() {
        current_position = getArguments().getInt(Key.POSITION);
        presenter = new DiscoveryListPresenterImpl(this);
        presenter.init(current_position);
        adapter.setType(current_position);
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
    public void showError(String str, int code) {
        if (code == GlobalConstant.layout_empty) {
            control_layout.showEmpty();
        } else if (code == GlobalConstant.layout_error) {
            control_layout.showError();
        } else if (code == GlobalConstant.layout_no_network) {
            control_layout.showNoNet();
        }
    }

    @Override
    public void onItemClick(View view, int postion) {

    }

    @Override
    public void onLoadSortSuccess(List<DiscoveryList1> data) {
        adapter.setData(data);
    }
}
