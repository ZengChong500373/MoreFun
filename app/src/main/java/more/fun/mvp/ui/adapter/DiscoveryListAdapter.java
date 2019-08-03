package more.fun.mvp.ui.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.easy.loader.GlideUtils;
import org.easy.ui.recycler.base.BaseRecyclerHolder;
import org.easy.ui.recycler.listener.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

import more.fun.mvp.R;
import more.fun.mvp.entity.DiscoveryList1;
import more.fun.mvp.ui.holder.DiscoveryHodler1;

/**
 * author : jyh
 * date : 2019-04-19
 * qq : 84714581
 * https://github.com/ZengChong500373
 * describe :
 */
public class DiscoveryListAdapter extends RecyclerView.Adapter<BaseRecyclerHolder> {
    protected List<DiscoveryList1> list = new ArrayList<>();
    private ItemClickListener itemListener;
    private int type = 0;

    public void setItemListener(ItemClickListener mListener) {
        this.itemListener = mListener;
    }

    @NonNull
    @Override
    public BaseRecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int currentType) {
        if (currentType == 0) {
            return null;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_discovery_list_item1, parent, false);
        return new DiscoveryHodler1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerHolder baseHolder, int i) {

        switch (getItemViewType(i)) {
            case 0:
                break;
            case 1:
                DiscoveryList1 bean = list.get(i);
                DiscoveryHodler1 hodler1 = (DiscoveryHodler1) baseHolder;
//                hodler1.type.setText("#"+bean.getName());
                GlideUtils.loadPic(bean.getHeaderImage(), hodler1.cover);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return type;
    }

    public void setType(int type) {
        this.type = type;
        notifyDataSetChanged();
    }

    public void setData(List<DiscoveryList1> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        return list.size();
    }
}
