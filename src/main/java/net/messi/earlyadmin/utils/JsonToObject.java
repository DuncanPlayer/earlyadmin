package net.messi.earlyadmin.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.messi.earlyadmin.VO.LogVo;

import java.util.List;

public class JsonToObject {

    public static List<LogVo> toObj(String content) {
        Gson gson = new Gson();
        List<LogVo> nearShops = gson.fromJson(content, new TypeToken<List<LogVo>>() {
        }.getType());
        return nearShops;
    }

}
