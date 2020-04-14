package net.messi.earlyadmin.controller;

import net.messi.earlyadmin.VO.UserLoginBackVo;
import net.messi.earlyadmin.VO.UserLoginVo;
import net.messi.earlyadmin.constant.IPAddress;
import net.messi.earlyadmin.mapper.NideshopUserMapper;
import net.messi.earlyadmin.pojo.NideshopUser;
import net.messi.earlyadmin.pojo.NideshopUserExample;
import net.messi.earlyadmin.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("layuiadmin/user")
@CrossOrigin
public class UserController {

    @Autowired
    private NideshopUserMapper userMapper;

    @ResponseBody
    @GetMapping("/login")
    public JSONResult userLogin(UserLoginVo loginVo) {
        NideshopUser user = userMapper.findOauthUser(loginVo.getUsername(),loginVo.getPassword());
        UserLoginBackVo backVo = new UserLoginBackVo();
        if (null != user) {
            backVo.setAccess_token(UUID.randomUUID()+"_"+user.getId());
            backVo.setoAuthStatus(user.getWeixinOpenid());
            backVo.setUser(user);
            backVo.setShopId(user.getId());
        }
        return JSONResult.ok(backVo);
    }

    @ResponseBody
    @GetMapping("/userList")
    public JSONResult userList(Integer page,Integer limit) {
        NideshopUserExample example = new NideshopUserExample();
        NideshopUserExample.Criteria criteria = example.createCriteria();
        criteria.andIdIsNotNull();
        List<NideshopUser> users =  userMapper.selectByExample(example);
        for (NideshopUser user:users){
            user.setAvatar(IPAddress.AvatorServer+user.getAvatar());
        }
        int start = (page - 1) * limit;
        int end = start + limit;
        if (null != users) {
            if (end >= users.size()) {
                if (start >= users.size()) {
                    return JSONResult.ok();
                } else {
                    return JSONResult.ok(users.subList(start, users.size()), users.size());
                }
            } else if (start >= users.size()) {
                return JSONResult.ok();
            }
        }
        return JSONResult.ok(users.subList(start,end),users.size());
    }

}
