package more.fun.mvp.entity;


import java.util.List;

/**
 * author : jyh
 * date : 2019-04-18
 * qq : 84714581
 * https://github.com/ZengChong500373
 * describe :
 */
public class HotTabs {

    /**
     * tabInfo : {"tabList":[{"id":0,"name":"周排行","apiUrl":"http://baobab.kaiyanapp.com/api/v4/rankList/videos?strategy=weekly","tabType":0,"nameType":0,"adTrack":null},{"id":1,"name":"月排行","apiUrl":"http://baobab.kaiyanapp.com/api/v4/rankList/videos?strategy=monthly","tabType":0,"nameType":0,"adTrack":null},{"id":2,"name":"总排行","apiUrl":"http://baobab.kaiyanapp.com/api/v4/rankList/videos?strategy=historical","tabType":0,"nameType":0,"adTrack":null}],"defaultIdx":0}
     */

    private TabInfoBean tabInfo;

    public TabInfoBean getTabInfo() {
        return tabInfo;
    }

    public void setTabInfo(TabInfoBean tabInfo) {
        this.tabInfo = tabInfo;
    }

    public static class TabInfoBean {
        /**
         * tabList : [{"id":0,"name":"周排行","apiUrl":"http://baobab.kaiyanapp.com/api/v4/rankList/videos?strategy=weekly","tabType":0,"nameType":0,"adTrack":null},{"id":1,"name":"月排行","apiUrl":"http://baobab.kaiyanapp.com/api/v4/rankList/videos?strategy=monthly","tabType":0,"nameType":0,"adTrack":null},{"id":2,"name":"总排行","apiUrl":"http://baobab.kaiyanapp.com/api/v4/rankList/videos?strategy=historical","tabType":0,"nameType":0,"adTrack":null}]
         * defaultIdx : 0
         */

        private int defaultIdx;
        private List<TabBean> tabList;

        public int getDefaultIdx() {
            return defaultIdx;
        }

        public void setDefaultIdx(int defaultIdx) {
            this.defaultIdx = defaultIdx;
        }

        public List<TabBean> getTabList() {
            return tabList;
        }

        public void setTabList(List<TabBean> tabList) {
            this.tabList = tabList;
        }

        public static class TabBean {
            /**
             * id : 0
             * name : 周排行
             * apiUrl : http://baobab.kaiyanapp.com/api/v4/rankList/videos?strategy=weekly
             * tabType : 0
             * nameType : 0
             * adTrack : null
             */

            private int id;
            private String name;
            private String apiUrl;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getApiUrl() {
                return apiUrl;
            }

            public void setApiUrl(String apiUrl) {
                this.apiUrl = apiUrl;
            }
        }
    }
}
