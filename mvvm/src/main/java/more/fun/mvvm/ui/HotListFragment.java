package more.fun.mvvm.ui;

import android.os.Bundle;

import org.easy.tools.Key;

import more.fun.mvvm.R;
import more.fun.mvvm.base.LazyFragment;
import more.fun.mvvm.databinding.FragmentDiscoveryHotListBinding;

/**
 * author : jyh
 * date : 2019/4/17
 * qq : 84714581
 * https://github.com/ZengChong500373
 * describe :
 */
public class HotListFragment extends LazyFragment<FragmentDiscoveryHotListBinding> {
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
    public void onFirstUserVisible() {

    }
}
