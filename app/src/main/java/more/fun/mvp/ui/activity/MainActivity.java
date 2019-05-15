package more.fun.mvp.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;

import org.easy.ui.viewpager.TabViewpager;

import more.fun.mvp.R;
import more.fun.mvp.ui.fragment.DiscoveryFragment;
import more.fun.mvp.ui.fragment.HomeFragment;
import more.fun.mvp.ui.fragment.HotFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TabViewpager tab_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
    }

    private void initViews() {
        findViewById(R.id.rg_daily_selection).setOnClickListener(this);
        findViewById(R.id.rg_discovery).setOnClickListener(this);
        findViewById(R.id.rg_popular).setOnClickListener(this);
    }

    private void initData() {
        tab_main=findViewById(R.id.tab_main);
        tab_main.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
        tab_main.setOffscreenPageLimit(3);
    }


    @Override
    public void onClick(View v) {
          switch (v.getId()){
              case R.id.rg_daily_selection:
                  tab_main.setCurrentItem(0,false);
                  break;
              case R.id.rg_discovery:
                  tab_main.setCurrentItem(1,false);
                  break;
              case R.id.rg_popular:
                  tab_main.setCurrentItem(2,false);
                  break;
                  default:
                      break;
          }
    }
    /**
     * Created by Administrator on 2016/9/7 0007.
     *
     * 主界面viewpager的适配器
     */
    public static class MainPagerAdapter extends FragmentStatePagerAdapter {
        private MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return MainFragmentFactory.getFragment(position);
        }

        @Override
        public int getCount() {
            return 3;
        }

        private static class MainFragmentFactory {
            private static SparseArray<Fragment> map = new SparseArray<Fragment>();

            private  static Fragment getFragment(int posistion) {
                Fragment currentFragment = map.get(posistion);
                if (currentFragment == null) {
                    switch (posistion) {
                        case 0:
                            map.put(0, new HomeFragment());
                            break;
                        case 1:
                            map.put(1,  new DiscoveryFragment());
                            break;
                        case 2:
                            map.put(2,new HotFragment());
                            break;
                        case 3:

                            break;
                        default:
                            break;
                    }
                    currentFragment = map.get(posistion);
                }
                return currentFragment;
            }
        }
    }



}
