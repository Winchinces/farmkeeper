package farmkeeperfly.com.tiankuai.network;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.RequestBody;

import java.io.File;

import farmkeeperfly.com.tiankuai.ReturnBean;
import farmkeeperfly.com.tiankuai.network.request.AddBitCustomers;
import farmkeeperfly.com.tiankuai.network.request.BaseRequest;
import farmkeeperfly.com.tiankuai.network.utils.HttpUtils;
import farmkeeperfly.com.tiankuai.network.utils.UrlUtils;

import static android.R.attr.tag;

/**
 * 网络的请求类
 * Created by zhangguang on 2016/5/23.
 */
public class NetWorkManager {

    private static final String DEFAULT_CACHE_DIR = "networkCache";

    public static int CONNECTION_TYPE;      //网络请求类型
    private static NetWorkManager mNetWorkManager;
    public Handler UIHandler;
    public DiskCache diskCache;

    private NetWorkManager() {
        UIHandler = new Handler(Looper.getMainLooper());
    }

    public static NetWorkManager getInstance() {
        if (mNetWorkManager == null) {
            mNetWorkManager = new NetWorkManager();
        }
        return mNetWorkManager;
    }

    /**
     * 初始化缓存,应该在Application初始化时初始化
     */
    public void initDiskCache(Context context) {
        File cacheDir = new File(context.getFilesDir(), DEFAULT_CACHE_DIR);
        diskCache = new DiskCache(cacheDir);
        diskCache.initialize();
    }

    /**
     * 取消相应tag的访问
     */
    public static void cancelRequest(Object tag) {
        HttpUtils.cancelRequest(tag);
    }


    public static void test(String id,String json,BaseRequest.Listener listener){

      /*  MultipartBuilder multipartBuilder = new MultipartBuilder().type(MultipartBuilder.FORM)
                .addFormDataPart("data", new Gson().toJson(plotBean));
*/

        MultipartBuilder multipartBuilder =new MultipartBuilder().type(MultipartBuilder.FORM).addFormDataPart("landinfo","{" +
                "    \"1001\": {" +
                "        \"address\": \"XX村XX号\"," +
                "        \"area\": 22.5," +
                "        \"crop\": \"水稻\"," +
                "        \"edit_tel\": \"xiemin\"," +
                "        \"farmname\": \"liuxp\"," +
                "        \"geom\": \"POLYGON((116.307169 39.944259, 116.306174 39.94461, 116.305962 39.944253, 116.30692 39.943895, 116.307169 39.944259, 116.307169 39.944259))\"," +
                "        \"obstacle\": \"\"," +
                "        \"photos\": \"\"," +
                "        \"remark\": \"about info2\"," +
                "        \"slope\": 1," +
                "        \"status\": 1," +
                "        \"tel\": \"18611111111\"," +
                "        \"time\": 1474592065," +
                "        \"type\": 1" +
                "    }" +
                "}");
        RequestBody requestBody=new FormEncodingBuilder().add("landinfo","{" +
                "    \"1001\": {" +
                "        \"address\": \"XX村XX号\"," +
                "        \"area\": 22.5," +
                "        \"crop\": \"水稻\"," +
                "        \"edit_tel\": \"xiemin\"," +
                "        \"farmname\": \"liuxp\"," +
                "        \"geom\": \"POLYGON((116.307169 39.944259, 116.306174 39.94461, 116.305962 39.944253, 116.30692 39.943895, 116.307169 39.944259, 116.307169 39.944259))\"," +
                "        \"obstacle\": \"\"," +
                "        \"photos\": \"\"," +
                "        \"remark\": \"about info2\"," +
                "        \"slope\": 1," +
                "        \"status\": 1," +
                "        \"tel\": \"18611111111\"," +
                "        \"time\": 1474592065," +
                "        \"type\": 1" +
                "    }" +
                "}").build();

       /* if(filepathList!=null&&filepathList.size()>0){
            File file;
            for (int i = 0; i <filepathList.size() ; i++) {
                file=new File(filepathList.get(i));
                multipartBuilder
                        .addFormDataPart("file" + (i + 1), file.getName(), RequestBody.create(null, file));
            }
        }*/

       // RequestBody requestBody = multipartBuilder.build();
        new AddBitCustomers(UrlUtils.test ,tag, listener, false, ReturnBean.class, ReturnBean.class).performNetwork(BaseRequest.Method.POST, requestBody);
    }
    }

    /**
     * 登录获取短信验证码
     * 请求方式：Post
     *
     * @param phone
     * @param listener
     * @param tag
     */

/*    public void getVerificationCode(String phone, BaseRequest.Listener listener, Object tag) {
        RequestBody requestBody = new FormEncodingBuilder().add("phone", phone).build();
        new SmsCodeTransRequest(UrlUtils.getSmsmCodeUrl(), tag, listener,
                false, ReturnResultBean.class, ReturnResultBean.class)
                .performNetwork(BaseRequest.Method.POST, requestBody);


    }*/

   /* *//**
     * 提现获取短信验证码
     * 请求方式：Post
     *
     * @param phone
     * @param listener
     * @param tag
     *//*
    public void getCarryCashInfoCode(String phone, BaseRequest.Listener listener, Object tag) {
        RequestBody requestBody = new FormEncodingBuilder().add("phone", phone).build();
        new SmsCodeTransRequest(UrlUtils.getCarryCashSmsCode(), tag, listener,
                false, ReturnResultBean.class, ReturnResultBean.class)
                .performNetwork(BaseRequest.Method.POST, requestBody);

    }


    *//**
     * 提现提交
     * 请求方式：Post
     *
     * @param listener
     * @param tag
     *//*
    public void postCarryInfo(BaseRequest.Listener listener, Object tag, RequestBody requestBody) {
        new SmsCodeTransRequest(UrlUtils.postCarryCashInfo(),tag,listener,
                false, CarryCashInfoBean.class,CarryCashInfoBean.class)
                .performNetwork(BaseRequest.Method.POST, requestBody);

    }


    *//**
     * 请求账户余额
     * 请求方式: post
     *
     * @param listener
     * @param tag
     * @param requestBody 请求体
     *//*
    public void postAcccountBalance(BaseRequest.Listener listener, Object tag, RequestBody requestBody) {

        new SmsCodeTransRequest(UrlUtils.postAccountBalance(), tag, listener,
                false, AccountBalanceBean.class, AccountBalanceBean.class)
                .performNetwork(BaseRequest.Method.POST, requestBody);

    }


    *//**
     * 提现请求账户信息
     * 请求方式: post
     *
     * @param listener
     * @param tag
     * @param requestBody 请求体
     *//*
    public void postAcccountInfo(BaseRequest.Listener listener, Object tag, RequestBody requestBody) {

        new SmsCodeTransRequest(UrlUtils.postAccountInfo(), tag, listener,
                true, CarryCashBean.class, CarryCashBean.class)
                .performNetwork(BaseRequest.Method.POST,true,false, requestBody);

    }

    *//**
     * 添加用户
     *//*
    public void postAddCustomer(BaseRequest.Listener listener, Object tag, RequestBody requestBody) {

        new SmsCodeTransRequest(UrlUtils.postAddCustomer(), tag, listener,
                false, ReturnResultBean.class, ReturnResultBean.class)
                .performNetwork(BaseRequest.Method.POST, requestBody);

    }
    // // TODO: 2016/8/9

    *//**
     * 获取钱包信息
     *//*
    public void getMyWalletInfo(BaseRequest.Listener listener, Object tag, RequestBody requestBody,String state) {

        new SmsCodeTransRequest(UrlUtils.getMyWalletInfo()+"?hfhe="+state, tag, listener,
                true, MyWalletBean.class, MyWalletBean.class)
                .performNetwork(BaseRequest.Method.POST,true,false, requestBody);

    }

    *//**
     * 请求已审核账户
     *//*

    public void getApprovedcustomer(BaseRequest.Listener listener, Object tag, RequestBody requestBody) {

        new SmsCodeTransRequest(UrlUtils.getApprovedcustomer(), tag, listener,
                true, ApproverCustomerBean.class, ApproverCustomerBean.class)
                .performNetwork(BaseRequest.Method.POST,true,false, requestBody);

    }

     *//**
     * 请求下单大客户
     *//*

    public void getApprovedClient(BaseRequest.Listener listener, Object tag, RequestBody requestBody) {

        new SmsCodeTransRequest(UrlUtils.queryClient(), tag, listener,
                true, OrderClientBean.class, OrderClientBean.class)
                .performNetwork(BaseRequest.Method.POST,true,false, requestBody);

    }



    *//**
     * 请求全部账户信息 HomeClient
     *//*
    public void getAllCustomer(BaseRequest.Listener listener,Object tag ,RequestBody requestBody ){

        new SmsCodeTransRequest(UrlUtils.getAllcustomer(),tag,listener,
                true, AllCustomerBean.class,AllCustomerBean.class)
                .performNetwork(BaseRequest.Method.POST,true,false, requestBody);

    }
    *//**
     * 请求订单信息 HomeOrder
     *//*

    public void getAllOrder(BaseRequest.Listener listener,Object tag ,RequestBody requestBody ){

        new SmsCodeTransRequest(UrlUtils.getAllOrder(),tag,listener,
                true, HomeOrderBean.class,HomeOrderBean.class)
                .performNetwork(BaseRequest.Method.POST,true,false, requestBody);

    }
    *//**
     * 请求订单详情
     *
     *//*

    public void getOrderDetail(String orderNumber, String type, BaseRequest.Listener listener, Object tag) {

        RequestBody requestBody = new FormEncodingBuilder().add("orderNumber", orderNumber)
                .add("type", type)
                .build();
        new AddBitCustomers(UrlUtils.getOrderdetail()+"?aaa="+orderNumber, tag, listener, true, OrderDetailBean.class, OrderDetailBean.class).performNetwork(BaseRequest.Method.POST, true, false, requestBody);

    }



    *//**
     * 业务员查询下的订单
     *//*

    public void getSaleManOrders(BaseRequest.Listener listener,Object tag ,RequestBody requestBody,int num ,String state){

        new SmsCodeTransRequest(UrlUtils.getSaleManOrders()+"?num="+num+"&statee="+state,tag,listener,
                true, HomeOrderBean.class,HomeOrderBean.class)
                .performNetwork(BaseRequest.Method.POST, true, false, requestBody);
       *//* new SmsCodeTransRequest(UrlUtils.getAllOrder()+"?num="+num+"&state="+state,tag,listener,
                true, HomeOrderBean.class,HomeOrderBean.class)
                .performNetwork(BaseRequest.Method.POST,true,false, requestBody);*//*

    }
    *//**
     * 请求提现进度(申请进度页面)
     *//*
    public void getWithdrawalSchedule(BaseRequest.Listener listener,Object tag ,RequestBody requestBody ){

        new SmsCodeTransRequest(UrlUtils.getWithdrawalschedule(),tag,listener,
                false, WithdrawalScheduleBean.class,WithdrawalScheduleBean.class)
                .performNetwork(BaseRequest.Method.POST, requestBody);

    }
    *//**
     * 请求支付订单信息 (8.11)
     *//*
    public void getPaymentOrderTnfo(BaseRequest.Listener listener,Object tag ,RequestBody requestBody,String orderNumber ){

        new SmsCodeTransRequest(UrlUtils.getPaymentordergetinfo()+"?=fjhh="+orderNumber,tag,listener,
                true, PaymentOrderBean.class,PaymentOrderBean.class)
                .performNetwork(BaseRequest.Method.POST, true,false,requestBody);

    }
    *//**
     * 取消订单
     *
     *//*

    public void postCancelOrder(BaseRequest.Listener listener,Object tag ,RequestBody requestBody ){

        new SmsCodeTransRequest(UrlUtils.postCancelOrder(),tag,listener,
                false, CancleOrderBean.class,CancleOrderBean.class)
                .performNetwork(BaseRequest.Method.POST, requestBody);

    }


    *//**
     * 请求HomeMy信息
     *//*
    public void getHomeMyInfo(BaseRequest.Listener listener,Object tag ,RequestBody requestBody ){

        new SmsCodeTransRequest(UrlUtils.getHomeMyInfo(),tag,listener,
                true, HomeMyFragmentBean.class,HomeMyFragmentBean.class)
                .performNetwork(BaseRequest.Method.POST,true,false, requestBody);

    }
    *//**
     * 大客户请求HomeMy信息
     *//*
    public void getBigHomeMyInfo(BaseRequest.Listener listener,Object tag ,RequestBody requestBody ){

        new SmsCodeTransRequest(UrlUtils.getBiginfo(),tag,listener,
                true, BigCustomerMyBean.class,BigCustomerMyBean.class)
                .performNetwork(BaseRequest.Method.POST,true,false, requestBody);

    }
    *//**
     * 直客提交(下订单)
     *
     *//*
    public void postDiredcPlaceOrder(BaseRequest.Listener listener,Object tag ,RequestBody requestBody ){

        new SmsCodeTransRequest(UrlUtils.postDirectPlaceOrder(),tag,listener,
                false, DirectPlaceOrderBean.class,DirectPlaceOrderBean.class)
                .performNetwork(BaseRequest.Method.POST, requestBody);

    }

    *//**
     * 业务员提交(下订单)
     *
     *//*
    public void postSaleManTakeOrder(BaseRequest.Listener listener,Object tag ,RequestBody requestBody ){

        new SmsCodeTransRequest(UrlUtils.getSaleManTakeOrder(),tag,listener,
                false, DirectPlaceOrderBean.class,DirectPlaceOrderBean.class)
                .performNetwork(BaseRequest.Method.POST, requestBody);

    }

  *//**
     * 业务员完善订单
     *
     *//*
    public void updateOrder(BaseRequest.Listener listener,Object tag ,RequestBody requestBody){

        new SmsCodeTransRequest(UrlUtils.getUpdateOrder(),tag,listener,
                false, DirectPlaceOrderBean.class,DirectPlaceOrderBean.class)
                .performNetwork(BaseRequest.Method.POST, requestBody);

    }



    *//**
     * 直客请求信息
     *//*
    public void getDiredcPlaceOrderInfo(BaseRequest.Listener listener,Object tag ,RequestBody requestBody ){

        new SmsCodeTransRequest(UrlUtils.getDirectplacegetinfo(), tag,listener,
                false, DirecdPlaceOrderInfo.class,DirecdPlaceOrderInfo.class)
                .performNetwork(BaseRequest.Method.POST, requestBody);

    }
    *//**
     * 代理下订单请求信息
     *//*

      *//**
     * 代理下订单请求信息

        new SmsCodeTransRequest(UrlUtils.getSaleManTakeOrder(),tag,listener,
                false, AgencyPlaceOrderpGetInfo.class,AgencyPlaceOrderpGetInfo.class)
                .performNetwork(BaseRequest.Method.POST, requestBody);
    }



//    *//**
//     * 代理支付订单请求信息(二维码)
//     *//*
//    public void getPaymentOrderInfo(BaseRequest.Listener listener,Object tag ,RequestBody requestBody ){
//
//        new SmsCodeTransRequest(UrlUtils.getPaymentordergetinfo(),tag,listener,
//                false, PaymentOrderBean.class,PaymentOrderBean.class)
//                .performNetwork(BaseRequest.Method.POST, requestBody);
//
//    }
    *//**
     * 请求订单是否支付成功
     *//*
    public void postOrderIsSucceed(BaseRequest.Listener listener,Object tag ,RequestBody requestBody ){

        new SmsCodeTransRequest(UrlUtils.postOrderIsSucceed(),tag,listener,
                false, OrderIsSucceedBean.class,OrderIsSucceedBean.class)
                .performNetwork(BaseRequest.Method.POST, requestBody);

    }


    *//**
     * 登录
     *
     * @param smsCode
     * @param phone
     * @param listener
     * @param tag
     *//*

    public void loginIn(String smsCode, String phone, BaseRequest.Listener listener, Object tag) {
        RequestBody requestBody = new FormEncodingBuilder().add("phone", phone).add("checkCode", smsCode).build();
        new LoginTransRequest(UrlUtils.loginUrl(),
                tag, listener, false, LoginBean.class, LoginBean.class)
                .performNetwork(BaseRequest.Method.POST, requestBody);

    }


    *//**
     * 测试登录
     *
     * @param phone
     * @param listener
     * @param tag
     *//*

    public void loginInTest(String phone, BaseRequest.Listener listener, Object tag) {
        RequestBody requestBody = new FormEncodingBuilder().add("phone", phone).build();
        new LoginTransRequest(UrlUtils.loginTestUrl(),
                tag, listener, false, LoginBean.class, LoginBean.class)
                .performNetwork(BaseRequest.Method.POST, requestBody);

    }
    *//**
     * 密码登录
     *//*
    public void loginPw(String phone, BaseRequest.Listener listener, Object tag,String passwprd) {
        RequestBody requestBody = new FormEncodingBuilder().add("phone", phone).add("passWord", passwprd).build();
        new LoginTransRequest(UrlUtils.logingPw(),
                tag, listener, false, LoginPwBean.class, LoginPwBean.class)
                .performNetwork(BaseRequest.Method.POST, requestBody);

    }
    *//**
     * 首次设置密码
     *//*
    public void setPasswprd(String accountId, String token,BaseRequest.Listener listener, Object tag,String password,String phone) {
        RequestBody requestBody = new FormEncodingBuilder().add("accountId", accountId).add("passWord", password).add("token", token).add("phone",phone).build();
        new LoginTransRequest(UrlUtils.setPassword(),
                tag, listener, false, SettingPwBean.class, SettingPwBean.class)
                .performNetwork(BaseRequest.Method.POST, requestBody);

    }
    *//**
     * 修改密码
     *//*

    public void changePassword(String checkCode,BaseRequest.Listener listener, Object tag,String password,String phone) {
        RequestBody requestBody = new FormEncodingBuilder().add("checkCode", checkCode).add("passWord", password).add("phone",phone).build();
        new LoginTransRequest(UrlUtils.changePw(),
                tag, listener, false, SettingPwBean.class, SettingPwBean.class)
                .performNetwork(BaseRequest.Method.POST, requestBody);

    }


    *//**
     * 3.查询大客户和合伙人
     *
     * @param salesmanId
     * @param listener
     * @param tag
     *//*
    public void queryCompany(String salesmanId,int num, BaseRequest.Listener listener, Object tag) {
        RequestBody requestBody = new FormEncodingBuilder().add("salesmanId", salesmanId).add("number",String.valueOf(num)).build();

        new QueryCompanyTransRequest(UrlUtils.queryCompanyUrl(), tag, listener, true, CompanyBean.class, CompanyBean.class).performNetwork(BaseRequest.Method.POST,true,false, requestBody);

    }


    *//**
     * 3.查询大客户和合伙人详细信息
     *
     * @param salesmanId
     * @param listener
     * @param tag
     *//*
    public void queryCompanyInfo(String salesmanId, String type, BaseRequest.Listener listener, Object tag) {
        RequestBody requestBody = new FormEncodingBuilder().add("accountId", salesmanId).add("type", type).build();
        new QueryCompanyTransRequest(UrlUtils.queryCompanyInfoUrl()+"?salesmanId="+salesmanId, tag, listener, true, CompanyInfoBean.class, CompanyInfoBean.class).performNetwork(BaseRequest.Method.POST,true,false, requestBody);

    }
*//*
添加大客户
 *//*

    public void addBitCustomers(String bigInstitutionsName, String bigResponsibleName, String bigResponsiblePhone, String bigAddress, String bigDetailedAddress, String salesmanId,String province,String contractNo, File partnerHeadUrl, BaseRequest.Listener listener, Object tag) {
        MultipartBuilder multipartBuilder = new MultipartBuilder().type(MultipartBuilder.FORM)
                .addFormDataPart("bigInstitutionsName", bigInstitutionsName)
                .addFormDataPart("bigResponsibleName", bigResponsibleName)
                .addFormDataPart("province", province)
                .addFormDataPart("bigResponsiblePhone", bigResponsiblePhone)
                .addFormDataPart("bigAddress", bigAddress)
                .addFormDataPart("bigDetailedAddress", bigDetailedAddress)
                .addFormDataPart("salesmanId", salesmanId)
                .addFormDataPart("contractNo", contractNo);
        if(partnerHeadUrl!=null){
            multipartBuilder
                    .addFormDataPart("partnerHeadUrl",  partnerHeadUrl.getName(), RequestBody.create(null, partnerHeadUrl));
        }

        RequestBody requestBody = multipartBuilder.build();
        new AddBitCustomers(UrlUtils.getAddbigcustomersUrl(), tag, listener, false, ReturnBean.class, ReturnBean.class).performNetwork(BaseRequest.Method.POST, requestBody);
    }

    *//**
     * 添加地块
     * @param plotBean
     * @param filepathList
     * @param listener
     * @param tag
     *//*
      public void addFarmland(PlotBean plotBean, List<String> filepathList, BaseRequest.Listener listener, Object tag) {
    *//*      JsonConfig config = new JsonConfig();
          // 忽略掉getDishDate属性
          config.setJsonPropertyFilter(new PropertyFilter(){
              @Override
              public boolean apply(Object arg0, String arg1, Object arg2) {
                  if (arg1.equals("getDishDate")) {
                      return true;
                  } else {
                      return false;
                  }
              }

          });*//*



          MultipartBuilder multipartBuilder = new MultipartBuilder().type(MultipartBuilder.FORM)
                .addFormDataPart("data", new Gson().toJson(plotBean));

          if(filepathList!=null&&filepathList.size()>0){
              File file;
              for (int i = 0; i <filepathList.size() ; i++) {
                  file=new File(filepathList.get(i));
                  multipartBuilder
                          .addFormDataPart("file" + (i + 1), file.getName(), RequestBody.create(null, file));
              }
          }

        RequestBody requestBody = multipartBuilder.build();
        new AddBitCustomers(UrlUtils.getAddfarmland(), tag, listener, false, ReturnBean.class, ReturnBean.class).performNetwork(BaseRequest.Method.POST, requestBody);
    }



    *//*
    添加合伙人
     *//*
    public void addCompany(String partnerName, String partnerPhone, String partnerIndustry, String partnerAddress, String partnerDetailedAddress, String partnerPaymentAccount, File partnerHeadUrl, String salesmanId,String province,String sex, BaseRequest.Listener listener, Object tag) {

        RequestBody requestBody = new MultipartBuilder().type(MultipartBuilder.FORM)
                .addFormDataPart("partnerName", partnerName)
                .addFormDataPart("partnerPhone", partnerPhone)
                .addFormDataPart("partnerIndustry", partnerIndustry)
                .addFormDataPart("partnerAddress", partnerAddress)
                .addFormDataPart("partnerDetailedAddress", partnerDetailedAddress)
                .addFormDataPart("partnerPaymentAccount", partnerPaymentAccount)
                .addFormDataPart("salesmanId", salesmanId)
                .addFormDataPart("province", province)
                .addFormDataPart("sex", sex)
                .addFormDataPart("partnerHeadUrl", partnerHeadUrl.getName(), RequestBody.create(null, partnerHeadUrl)).build();

        new AddBitCustomers(UrlUtils.getAddCompanyUrl(), tag, listener, false, ReturnBean.class, ReturnBean.class).performNetwork(BaseRequest.Method.POST, requestBody);
    }


    *//**
     * 代理下订单请求信息
     *//*
    public void getAgencyPlaceOrderInfo(BaseRequest.Listener listener,Object tag ,RequestBody requestBody ){

        new SmsCodeTransRequest(UrlUtils.getAgencyPlaceOrderInfo(),tag,listener,
                false, AgencyPlaceOrderpGetInfo.class,AgencyPlaceOrderpGetInfo.class)
                .performNetwork(BaseRequest.Method.POST, requestBody);

    }
 *//**
     *查询地块列表
     *//*
    public void getFarmLand(String accountId,BaseRequest.Listener listener,Object tag ){
        RequestBody requestBody = new FormEncodingBuilder().add("accountId", accountId).build();
        new SmsCodeTransRequest(UrlUtils.queryFarmland(),tag,listener,
                false, PlotListBean.class,PlotListBean.class)
                .performNetwork(BaseRequest.Method.POST, true, false, requestBody);

    }
    *//**
     *根据订单号查询地块列表
     *//*
    public void getFarmLandByOrderNumber(String orderNumber,BaseRequest.Listener listener,Object tag ){
        RequestBody requestBody = new FormEncodingBuilder().add("orderNumber", orderNumber).build();
        new SmsCodeTransRequest(UrlUtils.queryFarmlandbYOrderNumber(),tag,listener,
                false, PlotListBean.class,PlotListBean.class)
                .performNetwork(BaseRequest.Method.POST, true, false, requestBody);

    }


 *//**
     *查询地块详情
     *//*
    public void getPlotInfo(String farmlandNumber,BaseRequest.Listener listener,Object tag ){
        RequestBody requestBody = new FormEncodingBuilder().add("farmlandNumber", farmlandNumber).build();
        new SmsCodeTransRequest(UrlUtils.getQueryfarmlandinfo()+"?aa="+farmlandNumber,tag,listener,
                false, PlotInfoBean.class,PlotInfoBean.class)
                .performNetwork(BaseRequest.Method.POST,true, false,  requestBody);

    }

    *//**
     * 审核新用户
     *
     * @param partnershipId
     * @param area
     * @param block
     * @param state
     * @param listener
     * @param tag
     *//*

    public void checkNews(String partnershipId, String area, String block, String state, BaseRequest.Listener listener, Object tag) {
        RequestBody requestBody = new FormEncodingBuilder().add("partnershipId", partnershipId).add("area", area).add("block", block).add("state", state).build();
        new AddBitCustomers(UrlUtils.getNewpersonCheckUrl(), tag, listener, false, ReturnBean.class, ReturnBean.class).performNetwork(BaseRequest.Method.POST, requestBody);
    }

    *//**
     * 添加演示报告
     *//*
    public void addDisplayReport(String star, String peopleNumber, String homework, String wantPlaceOrder, String demoTime, String otherInstructions,String id, BaseRequest.Listener listener, Object tag) {
        RequestBody requestBody = new FormEncodingBuilder().add("star", star).add("peopleNumber", peopleNumber).add("homework", homework).add("wantPlaceOrder", wantPlaceOrder).add("id",id)
                .add("demoTime", demoTime).add("otherInstructions", otherInstructions).build();
        new AddBitCustomers(UrlUtils.getAdddisplayreport(), tag, listener, false, ReturnBean.class, ReturnBean.class).performNetwork(BaseRequest.Method.POST,true,false, requestBody);
    }

    *//**
     * 英雄榜
     *//*
    public void getHero(String businessId, String type, BaseRequest.Listener listener, Object tag) {
        RequestBody requestBody = new FormEncodingBuilder().add("businessId", businessId).add("type", type).build();

        new AddBitCustomers(UrlUtils.getSaleManQuery()+"?typ="+type, tag, listener, true, HeroBean.class, HeroBean.class).performNetwork(BaseRequest.Method.POST,true,false, requestBody);
    }


    *//**
     * 查看新用户列表
     *//*


//    *//**
//     * 获取天气
//     * 请求方式： POST
//     * @param uid
//     * @param token
//     * @param city
//     * @param listener
//     * @param tag
//     *//*
//    public void getWeatherData(String uid,String token,String city,BaseRequest.Listener listener,Object tag){
//        new WeatherTransRequest(UrlUtils.getWeatherUrl() + "/" + city,tag,listener,false, WeatherData.class,WeatherData.class)
//        .setHeader(uid,token)
//        .performNetwork(BaseRequest.Method.GET);
//    }
//
//
//    *//**
//     * 获取订单地图类别
//     * @param uid
//     * @param token
//     * @param listener
//     * @param tag
//     *//*
//    public void getOrderMapList(String uid,String token,BaseRequest.Listener listener,Object tag){
//        new OrderTransRequest(UrlUtils.getOrderMapListUrl(), tag, listener,false,
//                OrderMapBena.class,OrderMapBena.class)
//                .setHeader(uid, token)
//                .performNetwork(BaseRequest.Method.GET);
//    }
//
//
//    *//**
//     * 待接订单列表
//     * @param orderType    订单类别 0待接订单   1 待完成订单  2 已完成订单
//     * @param uid
//     * @param token
//     * @param coord         待接订单需要经纬度
//     * @param listener
//     * @param tag
//     * http://192.168.1.166/api/task/getWaitTaskList    userId: 2 token: 2
//     *//*
//    public void getWaitOrderList(int orderType,String uid,String token,String coord,BaseRequest.Listener listener,Object tag){
//
//        new OrderTransRequest(UrlUtils.getOrderListUrl(orderType,coord),tag,listener,false,
//                OrderListBean.class,OrderListBean.class)
//                .setHeader(uid, token)
//                .performNetwork(BaseRequest.Method.GET);
//    }
//
//    *//**
//     * 待完成订单列表
//     * @param orderType    订单类别 0待接订单   1 待完成订单  2 已完成订单
//     * @param uid
//     * @param token
//     * @param listener
//     * @param tag
//     * http://192.168.1.166/api/task/getWaitTaskList    userId: 2 token: 2
//     *//*
//    public void getCompleteOrderList(int orderType,String uid,String token,BaseRequest.Listener listener,Object tag){
//
//        new OrderTransRequest(UrlUtils.getOrderListUrl(orderType,null),tag,listener,false,
//                OrderListBean.class,OrderListBean.class)
//                .setHeader(uid, token)
//                .performNetwork(BaseRequest.Method.GET);
//    }
//
//    *//**
//     * 待接订单列表
//     * @param orderType    订单类别 0待接订单   1 待完成订单  2 已完成订单
//     * @param uid
//     * @param token
//     * @param listener
//     * @param tag
//     * http://192.168.1.166/api/task/getWaitTaskList    userId: 2 token: 2
//     *//*
//    public void getHasOrderList(int orderType,String uid,String token,BaseRequest.Listener listener,Object tag){
//
//        new OrderTransRequest(UrlUtils.getOrderListUrl(orderType,null),tag,listener,false,
//                OrderListBean.class,OrderListBean.class)
//                .setHeader(uid,token)
//                .performNetwork(BaseRequest.Method.GET);
//    }
//
//    *//**
//     * 接单
//     * @param orderId
//     * @param uid
//     * @param token
//     * @param listener
//     * @param tag
//     *//*
//    public void getConfirmOrder(String orderId,String uid,String token,BaseRequest.Listener listener,Object tag){
//        new ConfirmOrderRequest(UrlUtils.getConfirmOrderUrl(orderId),
//                tag,listener,false,ReturnBean.class,ReturnBean.class)
//                .setHeader(uid,token)
//                .performNetwork(BaseRequest.Method.POST);
//    }
//
//    *//**
//     * 确认订单任务
//     * @param orderId
//     * @param uid
//     * @param token
//     * @param listener
//     * @param tag
//     *//*
//    public void getTaskOrder(String orderId,String uid,String token,BaseRequest.Listener listener,Object tag){
//        new ConfirmOrderRequest(UrlUtils.getOrderTaskUrl(orderId),
//                tag,listener,false,ReturnBean.class,ReturnBean.class)
//                .setHeader(uid,token)
//                .performNetwork(BaseRequest.Method.POST);
//    }
//
//    *//**
//     * 订单详情
//     * @param orderId
//     * @param uid
//     * @param token
//     * @param listener
//     * @param tag
//     *//*
//    public void getOrderDetails(String orderId,String uid,String token,BaseRequest.Listener listener,Object tag ){
//        new OrderDetailTransRequest(UrlUtils.getOrderDetailUrl(orderId),
//                tag,listener,false, OrderDetailBean.class,OrderDetailBean.class)
//                .setHeader(uid,token)
//                .performNetwork(BaseRequest.Method.GET);
//    }
//
//    *//**
//     * 我的无人机
//     * @param uid
//     * @param token
//     * @param listener
//     * @param tag
//     *//*
//    public void getMyPlane(String uid,String token,BaseRequest.Listener listener,Object tag){
//        new OrderDetailTransRequest(UrlUtils.getPlaneUrl(),
//                tag,listener,false, PlanceBean.class,PlanceBean.class)
//                .setHeader(uid,token)
//                .performNetwork(BaseRequest.Method.GET);
//    }
//
//
//    *//**
//     * 附近服务站
//     * @param uid
//     * @param token
//     * @param listener
//     * @param tag
//     *//*
//    public void getNearService(String uid,String token,BaseRequest.Listener listener,Object tag){
//        new NearTransRequest(UrlUtils.getNearServiceUrl(),
//                tag,listener,false, NearServiceBean.class,NearServiceBean.class)
//                .setHeader(uid,token)
//                .performNetwork(BaseRequest.Method.GET);
//    }
//
//    *//**
//     * 获取个人信息
//     * @param uid
//     * @param token
//     * @param listener
//     * @param tag
//     *//*
//    public void getUserInfo(String uid,String token,BaseRequest.Listener listener,Object tag){
//        new UserInfoTransRequest(UrlUtils.getUserInfoUrl(),
//                tag,listener,false, UserInfoBean.class,UserInfoBean.class)
//                .setHeader(uid,token)
//                .performNetwork(BaseRequest.Method.GET);
//    }
    public void getNews(String salesmanId,int num, BaseRequest.Listener listener, Object tag) {
        RequestBody requestBody = new FormEncodingBuilder().add("salesmanId", salesmanId).add("number",String.valueOf(num)).build();
        new AddBitCustomers(UrlUtils.getNewpersonUrl()+"?hhahf="+salesmanId+"&nfhaum="+num, tag, listener, true, ApproverCustomerBean.class, ApproverCustomerBean.class).performNetwork(BaseRequest.Method.POST,true,false, requestBody);
    }


    *//**
     * 演示申请
     *//*

    public void displayApply(String name, BaseRequest.Listener listener, Object tag) {
        RequestBody requestBody = new FormEncodingBuilder().add("data", name)
                .build();
        new AddBitCustomers(UrlUtils.getDisplayApplyUrl(), tag, listener, false, ReturnBean.class, ReturnBean.class).performNetwork(BaseRequest.Method.POST, requestBody);
    }

    *//**
     * 查询业务员我的页面
     *//*


    public void getMyInfo(String businessId, BaseRequest.Listener listener, Object tag) {

        RequestBody requestBody = new FormEncodingBuilder().add("businessId", businessId)
                .build();
        new AddBitCustomers(UrlUtils.queryMy(), tag, listener, true, MyBean.class, MyBean.class).performNetwork(BaseRequest.Method.POST,true,false, requestBody);

    }

    *//**
     * 查询演示列表
     *//*


    public void getDisplayList(String salesmanId,int num, BaseRequest.Listener listener, Object tag) {

        RequestBody requestBody = new FormEncodingBuilder()
                .add("salesmanId", salesmanId)
                .add("number", String.valueOf(num))
                .build();
        new AddBitCustomers(UrlUtils.queryDisplay()+"?num="+num, tag, listener, true, DisplayListBean.class, DisplayListBean.class).performNetwork(BaseRequest.Method.POST,true,false, requestBody);

    }

    *//**
     * 查询演示详情列表
     *//*


    public void getDisplayInfo(String id, String state, BaseRequest.Listener listener, Object tag) {

        RequestBody requestBody = new FormEncodingBuilder().add("id", id)
                .add("state", state)
                .build();
        new AddBitCustomers(UrlUtils.queryDisplayInfo()+"?aaa="+id, tag, listener, true, DisplayItemBean.class, DisplayItemBean.class).performNetwork(BaseRequest.Method.POST,true,false, requestBody);

    }*/


//    /**
//     * 获取天气
//     * 请求方式： POST
//     * @param uid
//     * @param token
//     * @param city
//     * @param listener
//     * @param tag
//     */
//    public void getWeatherData(String uid,String token,String city,BaseRequest.Listener listener,Object tag){
//        new WeatherTransRequest(UrlUtils.getWeatherUrl() + "/" + city,tag,listener,false, WeatherData.class,WeatherData.class)
//        .setHeader(uid,token)
//        .performNetwork(BaseRequest.Method.GET);
//    }
//
//
//    /**
//     * 获取订单地图类别
//     * @param uid
//     * @param token
//     * @param listener
//     * @param tag
//     */
//    public void getOrderMapList(String uid,String token,BaseRequest.Listener listener,Object tag){
//        new OrderTransRequest(UrlUtils.getOrderMapListUrl(), tag, listener,false,
//                OrderMapBena.class,OrderMapBena.class)
//                .setHeader(uid, token)
//                .performNetwork(BaseRequest.Method.GET);
//    }
//
//
//    /**
//     * 待接订单列表
//     * @param orderType    订单类别 0待接订单   1 待完成订单  2 已完成订单
//     * @param uid
//     * @param token
//     * @param coord         待接订单需要经纬度
//     * @param listener
//     * @param tag
//     * http://192.168.1.166/api/task/getWaitTaskList    userId: 2 token: 2
//     */
//    public void getWaitOrderList(int orderType,String uid,String token,String coord,BaseRequest.Listener listener,Object tag){
//
//        new OrderTransRequest(UrlUtils.getOrderListUrl(orderType,coord),tag,listener,false,
//                OrderListBean.class,OrderListBean.class)
//                .setHeader(uid, token)
//                .performNetwork(BaseRequest.Method.GET);
//    }
//
//    /**
//     * 待完成订单列表
//     * @param orderType    订单类别 0待接订单   1 待完成订单  2 已完成订单
//     * @param uid
//     * @param token
//     * @param listener
//     * @param tag
//     * http://192.168.1.166/api/task/getWaitTaskList    userId: 2 token: 2
//     */
//    public void getCompleteOrderList(int orderType,String uid,String token,BaseRequest.Listener listener,Object tag){
//
//        new OrderTransRequest(UrlUtils.getOrderListUrl(orderType,null),tag,listener,false,
//                OrderListBean.class,OrderListBean.class)
//                .setHeader(uid, token)
//                .performNetwork(BaseRequest.Method.GET);
//    }
//
//    /**
//     * 待接订单列表
//     * @param orderType    订单类别 0待接订单   1 待完成订单  2 已完成订单
//     * @param uid
//     * @param token
//     * @param listener
//     * @param tag
//     * http://192.168.1.166/api/task/getWaitTaskList    userId: 2 token: 2
//     */
//    public void getHasOrderList(int orderType,String uid,String token,BaseRequest.Listener listener,Object tag){
//
//        new OrderTransRequest(UrlUtils.getOrderListUrl(orderType,null),tag,listener,false,
//                OrderListBean.class,OrderListBean.class)
//                .setHeader(uid,token)
//                .performNetwork(BaseRequest.Method.GET);
//    }
//
//    /**
//     * 接单
//     * @param orderId
//     * @param uid
//     * @param token
//     * @param listener
//     * @param tag
//     */
//    public void getConfirmOrder(String orderId,String uid,String token,BaseRequest.Listener listener,Object tag){
//        new ConfirmOrderRequest(UrlUtils.getConfirmOrderUrl(orderId),
//                tag,listener,false,ReturnBean.class,ReturnBean.class)
//                .setHeader(uid,token)
//                .performNetwork(BaseRequest.Method.POST);
//    }
//
//    /**
//     * 确认订单任务
//     * @param orderId
//     * @param uid
//     * @param token
//     * @param listener
//     * @param tag
//     */
//    public void getTaskOrder(String orderId,String uid,String token,BaseRequest.Listener listener,Object tag){
//        new ConfirmOrderRequest(UrlUtils.getOrderTaskUrl(orderId),
//                tag,listener,false,ReturnBean.class,ReturnBean.class)
//                .setHeader(uid,token)
//                .performNetwork(BaseRequest.Method.POST);
//    }
//
//    /**
//     * 订单详情
//     * @param orderId
//     * @param uid
//     * @param token
//     * @param listener
//     * @param tag
//     */
//    public void getOrderDetails(String orderId,String uid,String token,BaseRequest.Listener listener,Object tag ){
//        new OrderDetailTransRequest(UrlUtils.getOrderDetailUrl(orderId),
//                tag,listener,false, OrderDetailBean.class,OrderDetailBean.class)
//                .setHeader(uid,token)
//                .performNetwork(BaseRequest.Method.GET);
//    }
//
//    /**
//     * 我的无人机
//     * @param uid
//     * @param token
//     * @param listener
//     * @param tag
//     */
//    public void getMyPlane(String uid,String token,BaseRequest.Listener listener,Object tag){
//        new OrderDetailTransRequest(UrlUtils.getPlaneUrl(),
//                tag,listener,false, PlanceBean.class,PlanceBean.class)
//                .setHeader(uid,token)
//                .performNetwork(BaseRequest.Method.GET);
//    }
//
//
//    /**
//     * 附近服务站
//     * @param uid
//     * @param token
//     * @param listener
//     * @param tag
//     */
//    public void getNearService(String uid,String token,BaseRequest.Listener listener,Object tag){
//        new NearTransRequest(UrlUtils.getNearServiceUrl(),
//                tag,listener,false, NearServiceBean.class,NearServiceBean.class)
//                .setHeader(uid,token)
//                .performNetwork(BaseRequest.Method.GET);
//    }
//
//    /**
//     * 获取个人信息
//     * @param uid
//     * @param token
//     * @param listener
//     * @param tag
//     */
//    public void getUserInfo(String uid,String token,BaseRequest.Listener listener,Object tag){
//        new UserInfoTransRequest(UrlUtils.getUserInfoUrl(),
//                tag,listener,false, UserInfoBean.class,UserInfoBean.class)
//                .setHeader(uid,token)
//                .performNetwork(BaseRequest.Method.GET);
//    }



