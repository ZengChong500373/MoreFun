package more.fun.mvp.base;

/**
 * author : jyh
 * date : 2019-04-19
 * qq : 84714581
 * https://github.com/ZengChong500373
 * describe :
 */
public class HttpResponse<T> {
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public T getItemList() {
        return itemList;
    }

    public void setItemList(T itemList) {
        this.itemList = itemList;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    private int count ;

    private T itemList;

    private String nextPageUrl;


}
