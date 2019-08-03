package more.fun.mvp.ui.fragment;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;

import android.widget.ImageView;
import android.widget.TextView;

import org.easy.tools.utils.UiUtils;
import org.easy.ui.StatusControlLayout;

import more.fun.mvp.App;
import more.fun.mvp.R;
import more.fun.mvp.base.MvpFragment;
import more.fun.mvp.entity.HotTabs;
import more.fun.mvp.logic.HotContract;
import more.fun.mvp.logic.HotPresenterImpl;
import more.fun.mvp.ui.adapter.DiscoveryHotPagerAdapter;

/**
 * author : jyh
 * date : 2019/4/10
 * qq : 84714581
 * describe : 热门
 */
public class HotFragment extends MvpFragment<HotPresenterImpl> implements HotContract.View<HotTabs> {
    StatusControlLayout control_layout;
    TextView tv_header_title;
    ImageView img_search;
    TabLayout tab_layout;
    ViewPager vp;
    DiscoveryHotPagerAdapter adapter;
    @Override
    public int setFragmentView() {
        return R.layout.fragment_discovery_hot;
    }

    @Override
    public void initViews() {
        control_layout=find(R.id.control_layout);
        tv_header_title= (TextView) find(R.id.tv_header_title);
        tv_header_title.setText(UiUtils.getString(R.string.hot_rank));
        img_search= (ImageView) find(R.id.img_search);
        tab_layout= (TabLayout) find(R.id.tab_layout);
        vp= (ViewPager) find(R.id.vp);
        tab_layout.setupWithViewPager(vp);
        adapter=new DiscoveryHotPagerAdapter(getChildFragmentManager(),true);

    }

    @Override
    public void onFirstUserVisible() {
        presenter=new HotPresenterImpl(this);
        presenter.initTabs();
    }


    @Override
    public void onLoadSuccess(HotTabs hotTabs) {
        App.setHotTabs(hotTabs);
        for (HotTabs.TabInfoBean.TabBean bean:
             hotTabs.getTabInfo().getTabList()) {
            tab_layout.addTab(tab_layout.newTab().setText(bean.getName()));
        }
        vp.setOffscreenPageLimit(hotTabs.getTabInfo().getTabList().size());
        vp.setAdapter(adapter);
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
}
