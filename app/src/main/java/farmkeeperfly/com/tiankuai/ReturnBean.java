package farmkeeperfly.com.tiankuai;

import java.io.Serializable;

/**
 * 项目名称：MyApplication
 * 类描述：
 * 创建人：wencc
 * 创建时间：2016/9/26 11:03
 * 修改备注：
 */
public class ReturnBean implements Serializable{
    private int errno;
    private String errmsg = null;

    public String getErrmsg()
    {
        return errmsg;
    }

    public void setErrmsg(String errmsg)
    {
        this.errmsg = errmsg;
    }

    public String getData()
    {
        return data;
    }

    public void setData(String data)
    {
        this.data = data;
    }

    public int getErrno()
    {
        return errno;
    }

    public void setErrno(int errno)
    {
        this.errno = errno;
    }

    private String data;
}
