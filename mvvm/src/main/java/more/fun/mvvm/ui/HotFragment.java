package more.fun.mvvm.ui;

import android.util.Log;

import org.easy.tools.utils.UiUtils;

import more.fun.mvvm.R;
import more.fun.mvvm.base.LazyFragment;
import more.fun.mvvm.databinding.FragmentDiscoveryHotBinding;
import more.fun.mvvm.ui.adapter.DiscoveryHotPagerAdapter;

public class HotFragment extends LazyFragment<FragmentDiscoveryHotBinding> {
    DiscoveryHotPagerAdapter adapter;
    public String[] titles;
    @Override
    public int setFragmentView() {
        return R.layout.fragment_discovery_hot;
    }

    @Override
    public void initViews() {
        super.initViews();
        binding.tvHeaderTitle.setText(UiUtils.getString(R.string.hot_rank));
        adapter=new DiscoveryHotPagerAdapter(getChildFragmentManager(),false);
    }

    @Override
    public void onFirstUserVisible() {
        titles= UiUtils.getStringArray(R.array.hot_array);
        /**
         * forech  效率比 for ++ 更高
         * */
        for (String name : titles) {
            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(name));
        }
        binding.vp.setOffscreenPageLimit(titles.length);
        adapter.setData(titles);

        Log.e("hello vm","HotFragment");
    }
}
