package more.fun.mvp.http;

import io.reactivex.Observable;
import more.fun.mvp.entity.DiscoveryList1;
import more.fun.mvp.entity.HotList;
import more.fun.mvp.entity.HotTabs;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * author : jyh
 * date : 2019-04-18
 * qq : 84714581
 * https://github.com/ZengChong500373
 * describe :
 */
public interface HttpMethods {
    /**
     * 热门 顶部tab
     *
     * @return
     */
    @GET("v4/rankList")
    Observable<HotTabs> getHotTabs();

    /**
     * 热门的相关tab 的list
     *
     * @return
     */
    @GET
    Observable<HotList> getHotList(@Url String str);

    /**
     * 发现相关list 类型0
     *
     * @return
     */
    @GET
    Observable<HotList> getDisCoverList(@Url String str);
    /**
     * 发现相关list 类型1
     *
     * @return
     */
    @GET("v4/categories")
    Observable<DiscoveryList1> getDisCoverList1();
}
