package more.fun.mvp.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import org.easy.ui.recycler.base.BaseRecyclerHolder;
import org.easy.ui.recycler.listener.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * author : jyh
 * date : 2019-04-19
 * qq : 84714581
 * https://github.com/ZengChong500373
 * describe :
 */
public class DiscoveryListAdapter extends RecyclerView.Adapter<BaseRecyclerHolder> {
    protected List<String> list = new ArrayList<>();
    protected ItemClickListener itemListener;
private int type=0;
    public void setItemListener(ItemClickListener mListener) {
        this.itemListener = mListener;
    }
    @NonNull
    @Override
    public BaseRecyclerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int currentType) {
        if (currentType==0){
            return null;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerHolder baseRecyclerHolder, int i) {

    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        return 0;
    }
}
