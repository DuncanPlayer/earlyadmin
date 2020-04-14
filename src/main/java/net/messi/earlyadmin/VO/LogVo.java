package net.messi.earlyadmin.VO;

import java.io.Serializable;

public class LogVo implements Serializable {

    private String ip;
    private String url;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "LogVo{" +
                "ip='" + ip + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
