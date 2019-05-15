package more.fun.mvp.ui.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.easy.ui.recycler.base.BaseRecyclerHolder;

import more.fun.mvp.R;

/**
 * author : jyh
 * date : 2019-05-15
 * qq : 84714581
 * https://github.com/ZengChong500373
 * describe :
 */
public class DiscoveryHodler1 extends BaseRecyclerHolder {
   public ImageView cover;
   public TextView  type;
    public DiscoveryHodler1(View itemView) {
        super(itemView);
        cover=itemView.findViewById(R.id.cover);
        type=itemView.findViewById(R.id.type);
    }
}
