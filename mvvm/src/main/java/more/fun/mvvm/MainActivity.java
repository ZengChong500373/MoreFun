package more.fun.mvvm;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

import org.easy.ui.viewpager.TabViewpager;

import more.fun.mvvm.model.MainFragmentFactory;

public class MainActivity extends AppCompatActivity {
    private TabViewpager tab_main;
    private BottomNavigationView navigation;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    tab_main.setCurrentItem(0,false);
                    return true;
                case R.id.navigation_discovery:
                    tab_main.setCurrentItem(1,false);
                    return true;
                case R.id.navigation_popular:
                    tab_main.setCurrentItem(2,false);
                    return true;
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab_main=findViewById(R.id.tab_main);
        tab_main.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
        tab_main.setOffscreenPageLimit(1);
        navigation = findViewById(R.id.navigation);
        navigation.setItemIconTintList(null);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    /**
     * Created by Administrator on 2016/9/7 0007.
     *
     * 主界面viewpager的适配器
     */
    public static class MainPagerAdapter extends FragmentStatePagerAdapter {
        public MainPagerAdapter(FragmentManager fm) {
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
    }
}
