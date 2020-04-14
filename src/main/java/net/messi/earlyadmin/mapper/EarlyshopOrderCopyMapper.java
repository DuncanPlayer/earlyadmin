package net.messi.earlyadmin.mapper;

import java.util.List;

import net.messi.earlyadmin.pojo.EarlyshopOrderCopy;
import net.messi.earlyadmin.pojo.EarlyshopOrderCopyExample;
import org.apache.ibatis.annotations.Param;

public interface EarlyshopOrderCopyMapper {
    int countByExample(EarlyshopOrderCopyExample example);

    int deleteByExample(EarlyshopOrderCopyExample example);

    int insert(EarlyshopOrderCopy record);

    int insertSelective(EarlyshopOrderCopy record);

    List<EarlyshopOrderCopy> selectByExample(EarlyshopOrderCopyExample example);

    int updateByExampleSelective(@Param("record") EarlyshopOrderCopy record, @Param("example") EarlyshopOrderCopyExample example);

    int updateByExample(@Param("record") EarlyshopOrderCopy record, @Param("example") EarlyshopOrderCopyExample example);
}