package more.fun.mvp.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.easy.tools.utils.UiUtils;

import more.fun.mvp.R;
import more.fun.mvp.base.LazyFragment;
import more.fun.mvp.entity.HotTabs;
import more.fun.mvp.ui.adapter.DiscoveryHotPagerAdapter;

/**
 * author : jyh
 * date : 2019/4/10
 * qq : 84714581
 * describe : 发现
 *
 */
public class DiscoveryFragment extends LazyFragment {
    TextView tv_header_title;
    ImageView img_search;
    TabLayout tab_layout;
    ViewPager vp;
    DiscoveryHotPagerAdapter adapter;
    public String[] titles;
    @Override
    public int setFragmentView() {
        return R.layout.fragment_discovery_hot;
    }

    @Override
    public void initViews() {
        tv_header_title= (TextView) find(R.id.tv_header_title);
        tv_header_title.setText(UiUtils.getString(R.string.discovery));
        img_search= (ImageView) find(R.id.img_search);

        tab_layout= (TabLayout) find(R.id.tab_layout);
        tab_layout.setTabMode(TabLayout.GRAVITY_CENTER);
        vp= (ViewPager) find(R.id.vp);
        tab_layout.setupWithViewPager(vp);
        adapter=new DiscoveryHotPagerAdapter(getChildFragmentManager(),false);
        vp.setAdapter(adapter);
    }

    @Override
    public void onFirstUserVisible() {
        titles= UiUtils.getStringArray(R.array.discovery_array);
        for (String str:
                titles) {
            tab_layout.addTab(tab_layout.newTab().setText(str));
        }
        vp.setOffscreenPageLimit(titles.length);
        adapter.setData(titles);

    }
}
