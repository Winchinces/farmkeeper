package farmkeeperfly.com.tiankuai.network.request;

/**
 * Created by zhangguang on 2016/7/25.
 */
public class QueryCompanyTransRequest extends BaseTransRequest {
    public QueryCompanyTransRequest(String url, Object tag, Listener listener, boolean isCacheResult, Class from, Class to) {
        super(url, tag, listener, isCacheResult, from, to);
    }

   /* @Override
    protected Object parseNetWorkResponse(byte[] data) {

       *//* String json = new String(data);
        Gson gson = new Gson();
        CompanyBean companyBean=gson.fromJson(json, CompanyBean.class);
        List<CompanyBean.DatasBean.UserListBean> userList = companyBean.getDatas().getUserList();
       for (int i=0;i<userList.size();i++){
           CompanyBean.DatasBean.UserListBean userListBean = userList.get(i);
           userListBean.setPinyin(PinyinUtil.getPinyin(userListBean.getName()));
       }*//*


        return companyBean;
    }*/
}
