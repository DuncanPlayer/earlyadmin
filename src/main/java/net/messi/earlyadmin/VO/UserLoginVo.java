package net.messi.earlyadmin.VO;

import java.io.Serializable;

public class UserLoginVo implements Serializable {

    private String username;
    private String password;
    private String vercode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVercode() {
        return vercode;
    }

    public void setVercode(String vercode) {
        this.vercode = vercode;
    }

    @Override
    public String toString() {
        return "UserLoginVo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", vercode='" + vercode + '\'' +
                '}';
    }
}
