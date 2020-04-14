package net.messi.earlyadmin.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class BaseRedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    /**
     * @param key
     * @param value
     * @param time 分钟
     */
    public void set(String key,Object value,Long time) {
        if (value instanceof String){
            setString(key,value.toString());
        }
        if (value instanceof Set) {
            setSet(key,value);
        }
        //设置有效期
        if (null != time) {
            stringRedisTemplate.expire(key,time, TimeUnit.SECONDS);
        }
    }

    public void setString(String key,String value) {
        stringRedisTemplate.opsForValue().set(key,value);
    }

    public void setSet(String key,Object value) {
        Set<String> set = (Set<String>)value;
        for (String val:set){
            stringRedisTemplate.opsForValue().set(key,val);
        }
    }

    public String getValue(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void deleteKey(String key) {
        stringRedisTemplate.delete(key);
    }

}
