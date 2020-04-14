package net.messi.earlyadmin.mapper;

import java.util.List;

import net.messi.earlyadmin.pojo.NideshopUser;
import net.messi.earlyadmin.pojo.NideshopUserExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopUserMapper {
    int countByExample(NideshopUserExample example);

    int deleteByExample(NideshopUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NideshopUser record);

    int insertSelective(NideshopUser record);

    List<NideshopUser> selectByExample(NideshopUserExample example);

    NideshopUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NideshopUser record, @Param("example") NideshopUserExample example);

    int updateByExample(@Param("record") NideshopUser record, @Param("example") NideshopUserExample example);

    int updateByPrimaryKeySelective(NideshopUser record);

    int updateByPrimaryKey(NideshopUser record);

    NideshopUser findOauthUser(@Param("userName") String userName,@Param("password") String password);
}