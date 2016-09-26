package farmkeeperfly.com.tiankuai.network.utils;


import android.util.Log;

/**
 * 获取Url的全局类
 * Created by zhangguang on 2016/5/23.
 */
public class UrlUtils {

    /**
     * 服务器地址
     **/
//    public static final String URL = "http://192.168.1.165:8080";
    //   public static final String URL = "http://192.168.1.101:8080";
      public static final String URL = "http://192.168.102.244:8080/businessTreasure";


    public static final String test="http://123.56.252.160:8080/myjweb01_war/api/mulsetlandinfo";

//测试
  //  public static final String URL = BuildConfig.BASE_URL;

    public static final String PARAMETER = "?";

    //http://123.56.252.160:8080/businessTreasure/api/order/partnershipStatesQuery
    /**
     * 获取验证码
     **/
    public static final String SMSCODE = "/api/user/getSmsCheckCode";


    public static final String DOWNLOAD="http://farmlandbucket.oss-cn-beijing.aliyuncs.com/oa-helper.png";
      /**
     * 更新
     **/
    public static final String UPDATE = "/api/tool/versionQuery";



    /**
     * 登录
     **/
    public static final String LOGING = "/api/user/login";
    /**
     * 密码登录
     */
    public  static  final  String LOGINGPW="/api/user/loginP";

    /**
     * 测试登录
     **/
    public static final String LOGINGTAST = "/api/user/loginTest";

    /**
     * 首次设置密码
     */
    public  static  final  String SETPW="/api/user/updatePwByToken";
    /**
     * 修改密码
     */
    public static  final  String CHANGEPW="/api/user/updatePwByPhone";

    /**
     * 查询大客户和合伙人
     **/

    public static final String ACCOUNTQUERY = "/api/user/accountQuery";

    /**
     * 查询大客户和合伙人详细信息
     **/

    public static final String USERQUERY = "/api/user/userQuery";

    /**
     * 提现
     **/
    public static final String CARRYCASHSMSCODE = "/api/user/getCheckCode";

    /**
     * 提现短信验证成功
     **/
    public static final String CARRYCASHSMSCODECOMMIT = "/api/user/addWithdrawal";


    /**
     * 请账户余额
     */
    public static final String ACCOUNTBALANCE = "/api/user/userWalletQuery";
    /**
     * 账户信息
     **/
    public static final String ACCOUNTINFO = "/api/user/paymentAccountQuery";
    ///api/user/paymentAccountQuery

    /**
     * 添加大客户
     **/
    public static final String ADDBIGCUSTOMERS = "/api/user/addBigCustomers";


    /**
     * 添加账户
     */
    public static final String ADDCUSTOMER = "/api/order/addPartnership";
    /**
     * 已审核账户
     */

    public static final String APPROVEDCUSTOMER = "/api/order/partnershipStateQuery";

    /*业务员查询下的订单 */
    public static final String QUERYSALEMANORDERS = "/api/order/salesmanOrderQuery";


 /*查询大客户*/
    public static final String QUERYCLIENT = "/api/user/salesmanQuery";

    /**
     * 全部账户
     */
    public static final String ALLCUSTOMER = "/api/order/orderpartnershipQuery";
    /**
     * 订单页
     */
    public static final String ALLORDER = "/api/order/orderQuery";
                                                    //orderQuery


    /**
     * 订单详情
     */
    public static final String ORDERDETAIL="/api/order/orderDetailedQuery";

    /**
     * 请求支付订单信息
     */
    public static  final String PAYMENTORDERINFO="/api/order/addOrderQuery";

    /**
     * 直客下订单(提交信息)
     */
    public  static  final  String DIRECTPLACEORDER="/api/order/addOrderQuery";
    /**
     * 直客 请求信息
     */
    public  static  final String DIRECTPLACEGETINFO="/api/user/bigCustomersQuery";

    /**
     * 代理下订单请求信息
     */
    public  static  final String AGENCYPLACEORDERGETINFO="/api/tool/cropsQuery";
    /**
     * 业务员下订单请求信息
     */
    public  static  final String SALEMANTAKEORDER="/api/order/addOrderQuery";
    /**
     * 代理支付订单请求信息(二维码)
     */
    public  static  final String PAYMENTORDERGETINFO="/api/pay/payCode";
    /**
     * 代理取消订单支付(二维码)
     */
    public  static  final  String CANCELORDER="/api/order/updateOrderState";

    /**
     *  请求是否订单支付成功
     */
    public  static  final  String ORDERISSUCCEED="/api/pay/orderStateQuery";

    /**
     * (HomeMy)请求信息
     */
    public  static  final  String MYINFO="/api/user/partnerQuery";
    /**
     * 大客户请求my信息
     */
    public static  final  String BIGINFO="/api/user/bigCustomersQuery";
    /**
     * 添加大客户
     **/
    public static final String ADDCOMPANY = "/api/user/addPartner";
    /*
    新用户列表
    //http://123.56.252.160:8080/businessTreasure/api/order/partnershipStatesQuery
     */
    private static final String NEWPERSON = "/api/order/partnershipStatesQuery";
    /**
     * 新用户审核
     */
    private static final String NEWPERSONCHECK = "/api/order/partnershipUpdate";
    /**
     * 钱包
     **/
    public static final String MYWALLET = "/api/user/walletDetailsQuery";
 /**
     * 完善订单接口
     **/
    public static final String UPDATEORDER = "/api/order/updateOrder";

    /**
     * 添加地块信息
     **/
    public static final String ADDFARMLAND = "/api/farmland/addFarmland";

 /**
     * 查询地块列表
     **/
    public static final String QUERYFARMLAND = "/api/farmland/queryFarmlandByUser";

/**
     * 根据订单号查询地块列表
     **/
    public static final String QUERYFARMLANDBYORDERNUMBER = "/api/farmland/queryOrderFarmland";


    /**
     * 根据订单号查询地块列表
     */
    public static String queryFarmlandbYOrderNumber() {
        return URL + QUERYFARMLANDBYORDERNUMBER;

    }
/**
     * 查询地块列表
     */
    public static String queryFarmland() {
        return URL + QUERYFARMLAND;

    }

    /**
     * 添加地块信息
     */
    public static String getAddfarmland() {
        return URL + ADDFARMLAND;

    }
    /**
     * 完善订单接口
     */
    public static String getUpdateOrder() {
        return URL + UPDATEORDER;

    }




    /**
     * 获取我的钱包信息
     */
    public static String getMyWalletInfo() {
        return URL + MYWALLET;

    }

    /**
     * 申请演示
     */
    private static String DISPLAYAPPLY = "/api/demo/addDemo";


    /**
     * 业务员我页面
     */
    private static final String BUSSINESSMYQUERY = "/api/user/businessWoQuery";


    /**
     * 演示查询
     */
    private static final String DISPLAYLIST = "/api/demo/demoQuery";


    /**
     * 演示详情查询
     */
    private static final String DISPLAYINFO = "/api/demo/demoByQuery";
    /**
     * 申请进度查询
     */
    private static final String
            WITHDRAWALSCHEDULE= "/api/user/withdrawalQuery";

    /**
     * 添加演示报告
     */
    private static final String ADDDISPLAYREPORT = "/api/demo/addDemoReport";

    /**
     * 地块详细信息
     */
    private static final String QUERYFARMLANDINFO = "/api/farmland/queryFarmlandInfo";

  /**
     * 英雄榜
     */
    private static final String SALEMANQUERY = "/api/user/businessQuery";


    /**
     * 获取验证码
     *
     * @param phone 手机号
     * @return
     */
    public static String getSmsmCodeUrl(String phone) {
        return URL + SMSCODE + phone;
    }

    public static String getSmsmCodeUrl() {
        return URL + SMSCODE;
    }

    /**
     * 获取提现验证码
     * @return
     */
    public static String getCarryCashSmsCode() {
        return URL + CARRYCASHSMSCODE;
    }

    /**
     * 地块详细信息
     * @return
     */
    public static String getQueryfarmlandinfo() {
        return URL + QUERYFARMLANDINFO;
    }


    /**
     * 添加客户请求
     */
    public static String postAddCustomer() {
        return URL + ADDCUSTOMER;
    }

    /**
     * 已审核账户请求(选择客户)
     */

    public static String getApprovedcustomer() {
        return URL + APPROVEDCUSTOMER;
    }

    /**
     *  HomeClient全部账户信息请求
     */
    public  static  String  getAllcustomer(){
        return  URL+ALLCUSTOMER;
    }
    /**
     * HomeOrder请求订单页
     */
    public  static  final  String getAllOrder(){
        return  URL+ALLORDER;
    }

    /**
     * 业务员查询下的订单
     */
    public  static  final  String getSaleManOrders(){
        return  URL+QUERYSALEMANORDERS;
    }

    /**
     * 查询订单详情
     */
    public  static  final  String getOrderdetail(){
        return  URL+ORDERDETAIL;
    }


    /**
     * 大客户请求个人信息
     */
    public static  final String getBiginfo(){
    return  URL+BIGINFO;
        }

    /**
     * 直客下订单
     */
    public  static  final  String postDirectPlaceOrder(){
        return  URL+DIRECTPLACEORDER;
    }
    /**
     * 直客请求信息
     */
    public  static  final  String getDirectplacegetinfo(){
        return  URL+DIRECTPLACEGETINFO;
    }
    /**
     *  代理下订单请求信息
     */
    public  static  final  String getAgencyPlaceOrderInfo(){
        return  URL+AGENCYPLACEORDERGETINFO;
    }
    /**
     * 支付订单请求信息(二维码)
     */
    public  static  final String getPaymentordergetinfo(){
        return  URL+PAYMENTORDERGETINFO;
    }
    /**
     * 取消订单请求
     */
    public  static  final  String postCancelOrder(){
        return  URL+CANCELORDER;
    }
    /**
     * 请求订单是否支付成功
     */
    public  static  final  String postOrderIsSucceed(){
        return  URL+ORDERISSUCCEED;
    }

    /**
     * 申请进度查询请求
     */
    public static  final  String getWithdrawalschedule(){
    return  URL+WITHDRAWALSCHEDULE;
    }
    /**
     * 请求支付订单信息
     */
    public static  final  String  getPaymentorderinfo(){
        return  URL+PAYMENTORDERINFO;
    }
    /**
     * 请求HomeMy信息
     */
    public  static  final  String  getHomeMyInfo(){
        return URL+MYINFO;
    }

    /**
     * 查询余额
     *
     * @return
     */
    public static String postAccountBalance() {
        return URL + ACCOUNTBALANCE;
    }

  /**
   * 提现账户信息(提交)
   *
   * @return
   */
  public static String postAccountInfo() {
    return URL+ ACCOUNTINFO;
    }

    /**
     * 提交提现信息
     *
     * @return
     */
    public static String postCarryCashInfo() {
        Log.i("url","+++++url:"+URL + CARRYCASHSMSCODECOMMIT);
        return URL + CARRYCASHSMSCODECOMMIT;
    }

    /**
     * 登录
     *
     * @return
     */
    public static String loginUrl() {
        return URL + LOGING;

    }
    /**
     *密码登录
     */

    public  static  String logingPw(){
        return  URL+LOGINGPW;
    }

    /**
     * 首次设置密码
     */

    public  static  String setPassword(){
        return  URL+SETPW;
    }

    /**
     * 修改密码
     */

    public  static  String changePw(){
        return  URL+CHANGEPW;
    }
 /**
     * 业务员下订单接口
     *
     * @return
     */
    public static String getSaleManTakeOrder() {
        return URL + SALEMANTAKEORDER;

    }

 /**
     * 测试登录
     *
     * @return
     */
    public static String loginTestUrl() {
        return URL + LOGINGTAST;

    }

    /**
     * 大客户和合伙人信息
     *
     * @return
     */
    public static String queryCompanyUrl() {
        return URL + ACCOUNTQUERY;
    }

  /**
     * 版本更新
     *
     * @return
     */
    public static String  getUpdateUrl() {
        return URL + UPDATE;
    }

    /**
     * 大客户和合伙人详细
     *
     * @return
     */
    public static String queryCompanyInfoUrl() {
        return URL + USERQUERY;
    }

    /**
     * 添加大客户
     */

    public static String getAddbigcustomersUrl() {
        return URL + ADDBIGCUSTOMERS;
    }

    /**
     * 添加联系人
     */

    public static String getAddCompanyUrl() {
        return URL + ADDCOMPANY;
    }

    /**
     * 查询新用户
     */

    public static String getNewpersonUrl() {
        return URL + NEWPERSON;
    }

    /**
     * 审核新用户
     */

    public static String getNewpersonCheckUrl() {
        return URL + NEWPERSONCHECK;
    }

    /**
     * 演示申请
     */

    public static String getDisplayApplyUrl() {
        return URL + DISPLAYAPPLY;
    }


    /**
     * 业务员我的
     */

    public static String queryMy() {
        return URL + BUSSINESSMYQUERY;
    }

    /**
     * 演示列表查询
     */

    public static String queryDisplay() {
        return URL + DISPLAYLIST;
    }

    /**
     * 演示详情查询
     */

    public static String queryDisplayInfo() {
        return URL + DISPLAYINFO;
    }

    /**
     * 演示报告添加
     */

    public static String getAdddisplayreport() {
        return URL + ADDDISPLAYREPORT;
    }


    /**
     * 业务员查询
     */

    public static String getSaleManQuery() {
        return URL + SALEMANQUERY;
    }

 /**
     * 二维码查询
     */

    public static String getDownloadPath() {
        return DOWNLOAD;

    }
/**
     * 业务员查询大客户
     */

    public static String queryClient() {
        return URL+QUERYCLIENT;

    }


}
