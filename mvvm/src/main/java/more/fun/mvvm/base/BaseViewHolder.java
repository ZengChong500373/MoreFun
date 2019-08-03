package more.fun.mvvm.base;

import androidx.databinding.ViewDataBinding;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

public class BaseViewHolder<T extends ViewDataBinding>  extends RecyclerView.ViewHolder {
    public T binding;
    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }
    public void setBind(T binding) {
        this.binding = binding;
    }
    public T getBinding(){
        return binding;
    }

}
