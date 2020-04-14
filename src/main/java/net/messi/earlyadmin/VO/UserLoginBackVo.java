package net.messi.earlyadmin.VO;

import net.messi.earlyadmin.pojo.NideshopUser;

import java.io.Serializable;

public class UserLoginBackVo implements Serializable {

    private String access_token;
    private NideshopUser user;
    //系统管理员or店铺管理员
    private String oAuthStatus;
    private Integer shopId;

    public Integer getShopId() {
        return shopId;
    }
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
    public String getoAuthStatus() {
        return oAuthStatus;
    }
    public void setoAuthStatus(String oAuthStatus) {
        this.oAuthStatus = oAuthStatus;
    }
    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public NideshopUser getUser() {
        return user;
    }

    public void setUser(NideshopUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserLoginBackVo{" +
                "access_token='" + access_token + '\'' +
                ", user=" + user +
                ", oAuthStatus='" + oAuthStatus + '\'' +
                '}';
    }
}
