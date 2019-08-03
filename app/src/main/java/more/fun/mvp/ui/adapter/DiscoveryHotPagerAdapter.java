package more.fun.mvp.ui.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import more.fun.mvp.App;
import more.fun.mvp.ui.fragment.DiscoveryListFragment;
import more.fun.mvp.ui.fragment.HotListFragment;

/**
 * author : jyh
 * date : 2019/4/10
 * qq : 84714581
 * describe :
 */
public class DiscoveryHotPagerAdapter extends FragmentStatePagerAdapter {

    private boolean isHot;
    private String[] titles;
    public DiscoveryHotPagerAdapter(FragmentManager fm,boolean isHot) {
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
        if (isHot){
            if (App.getHotTabs()==null)return  0;
            return App.getHotTabs().getTabInfo().getTabList().size();
        }
        int size=titles==null?0:titles.length;
        return size;


    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (isHot)
        {
            return App.getHotTabs().getTabInfo().getTabList().get(position).getName();
        }
       return titles[position];
    }
    public void setData(String[] titles){
        this.titles=titles;
        notifyDataSetChanged();
    }

}
