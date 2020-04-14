package net.messi.earlyadmin.mapper;

import java.util.List;

import net.messi.earlyadmin.pojo.EarlyshopOrderGoodsCopy;
import net.messi.earlyadmin.pojo.EarlyshopOrderGoodsCopyExample;
import org.apache.ibatis.annotations.Param;

public interface EarlyshopOrderGoodsCopyMapper {
    int countByExample(EarlyshopOrderGoodsCopyExample example);

    int deleteByExample(EarlyshopOrderGoodsCopyExample example);

    int insert(EarlyshopOrderGoodsCopy record);

    int insertSelective(EarlyshopOrderGoodsCopy record);

    List<EarlyshopOrderGoodsCopy> selectByExampleWithBLOBs(EarlyshopOrderGoodsCopyExample example);

    List<EarlyshopOrderGoodsCopy> selectByExample(EarlyshopOrderGoodsCopyExample example);

    int updateByExampleSelective(@Param("record") EarlyshopOrderGoodsCopy record, @Param("example") EarlyshopOrderGoodsCopyExample example);

    int updateByExampleWithBLOBs(@Param("record") EarlyshopOrderGoodsCopy record, @Param("example") EarlyshopOrderGoodsCopyExample example);

    int updateByExample(@Param("record") EarlyshopOrderGoodsCopy record, @Param("example") EarlyshopOrderGoodsCopyExample example);
}