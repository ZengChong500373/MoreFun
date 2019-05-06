package more.fun.mvp.ui.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import org.easy.ui.recycler.base.BaseRecyclerAdapter;
import org.easy.ui.recycler.base.BaseRecyclerHolder;

import more.fun.mvp.R;
import more.fun.mvp.entity.HotList;

/**
 * author : jyh
 * date : 2019-04-19
 * qq : 84714581
 * https://github.com/ZengChong500373
 * describe :
 */
public class HotListAdapter extends BaseRecyclerAdapter<HotList.HotItem, HotListAdapter.HotListHolder> {

    @NonNull
    @Override
    public HotListHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_hot_list_item, parent, false);
        return new HotListHolder(view);
    }

    @Override
    public void MyHolder(@NonNull HotListHolder holder, int position) {
        super.MyHolder(holder, position);
        HotList.HotItem bean=list.get(position);
        Glide.with(holder.img.getContext())
                .load(bean.getData().getCover().getFeed())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.img);
       holder.tv_title.setText(bean.getData().getTitle());
        holder.tv_type.setText("#"+bean.getData().getCategory());
    }

    class HotListHolder extends BaseRecyclerHolder{
        ImageView img;
        TextView tv_title,tv_type;
        HotListHolder(View itemView) {
           super(itemView);
           img=itemView.findViewById(R.id.img);
           tv_title=itemView.findViewById(R.id.tv_title);
           tv_type=itemView.findViewById(R.id.tv_type);
       }
   }
}
