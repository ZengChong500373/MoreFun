package more.fun.mvvm.ui.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import more.fun.mvvm.ui.DiscoveryListFragment;
import more.fun.mvvm.ui.HotListFragment;


/**
 * author : jyh
 * date : 2019/4/10
 * qq : 84714581
 * describe :
 */
public class DiscoveryHotPagerAdapter extends FragmentStatePagerAdapter {
    private String[] titles;
    private boolean isHot;
    public DiscoveryHotPagerAdapter(FragmentManager fm, boolean isHot) {
        super(fm);
        this.isHot=isHot;
    }

    @Override
    public Fragment getItem(int i) {
        if (isHot){
            return HotListFragment.newInstance(i);
        }
        return DiscoveryListFragment.newInstance(i);
    }

    @Override
    public int getCount() {
        if (titles==null)return  0;
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    public  void setData(String [] news_head_list){
        this.titles=news_head_list;
        notifyDataSetChanged();

    }

}
