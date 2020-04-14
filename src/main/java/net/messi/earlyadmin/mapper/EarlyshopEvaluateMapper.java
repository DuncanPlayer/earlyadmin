package net.messi.earlyadmin.mapper;

import java.util.List;
import net.messi.earlyadmin.pojo.EarlyshopEvaluate;
import net.messi.earlyadmin.pojo.EarlyshopEvaluateExample;
import org.apache.ibatis.annotations.Param;

public interface EarlyshopEvaluateMapper {
    int countByExample(EarlyshopEvaluateExample example);

    int deleteByExample(EarlyshopEvaluateExample example);

    int insert(EarlyshopEvaluate record);

    int insertSelective(EarlyshopEvaluate record);

    List<EarlyshopEvaluate> selectByExample(EarlyshopEvaluateExample example);

    int updateByExampleSelective(@Param("record") EarlyshopEvaluate record, @Param("example") EarlyshopEvaluateExample example);

    int updateByExample(@Param("record") EarlyshopEvaluate record, @Param("example") EarlyshopEvaluateExample example);
}