package more.fun.mvvm.ui;

import more.fun.mvvm.R;
import more.fun.mvvm.base.LazyFragment;
import more.fun.mvvm.databinding.FragmentHomeBinding;

public class HomeFragment extends LazyFragment<FragmentHomeBinding> {
    @Override
    public int setFragmentView() {
        return R.layout.fragment_home;
    }

    @Override
    public void onFirstUserVisible() {

    }
}
