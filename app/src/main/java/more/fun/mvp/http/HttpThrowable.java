package more.fun.mvp.http;

import io.reactivex.functions.Consumer;
import more.fun.mvp.base.BaseResponseView;
import more.fun.mvp.base.GlobalConstant;

/**
 * author : jyh
 * date : 2019-05-06
 * qq : 84714581
 * https://github.com/ZengChong500373
 * describe :
 */
public class HttpThrowable implements Consumer<Throwable> {
    private static final HttpThrowable ourInstance = new HttpThrowable();

    private BaseResponseView view;
    public static HttpThrowable getInstance() {
        return ourInstance;
    }

    private HttpThrowable() {
    }

    @Override
    public void accept(Throwable throwable) throws Exception {
         if (this.view==null)
             return;
         this.view.showError("error", GlobalConstant.layout_error);
    }
    public void setView(BaseResponseView view){
     this.view=view;
    }
}
