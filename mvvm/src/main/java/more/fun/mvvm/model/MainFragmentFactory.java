package more.fun.mvvm.model;

import androidx.fragment.app.Fragment;
import android.util.SparseArray;

import more.fun.mvvm.ui.DiscoveryFragment;
import more.fun.mvvm.ui.HomeFragment;
import more.fun.mvvm.ui.HotFragment;


/**
 * Created by Administrator on 2017/4/13.
 */

public class MainFragmentFactory {
    private static SparseArray<Fragment> map = new SparseArray<Fragment>();

    public static Fragment getFragment(int posistion) {
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
