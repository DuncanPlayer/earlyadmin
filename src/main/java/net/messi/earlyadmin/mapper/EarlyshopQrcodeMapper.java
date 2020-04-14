package net.messi.earlyadmin.mapper;

import java.util.List;

import net.messi.earlyadmin.pojo.EarlyshopQrcode;
import net.messi.earlyadmin.pojo.EarlyshopQrcodeExample;
import org.apache.ibatis.annotations.Param;

public interface EarlyshopQrcodeMapper {
    int countByExample(EarlyshopQrcodeExample example);

    int deleteByExample(EarlyshopQrcodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EarlyshopQrcode record);

    int insertSelective(EarlyshopQrcode record);

    List<EarlyshopQrcode> selectByExample(EarlyshopQrcodeExample example);

    EarlyshopQrcode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EarlyshopQrcode record, @Param("example") EarlyshopQrcodeExample example);

    int updateByExample(@Param("record") EarlyshopQrcode record, @Param("example") EarlyshopQrcodeExample example);

    int updateByPrimaryKeySelective(EarlyshopQrcode record);

    int updateByPrimaryKey(EarlyshopQrcode record);
}