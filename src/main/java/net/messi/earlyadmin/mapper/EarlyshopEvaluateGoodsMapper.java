package net.messi.earlyadmin.mapper;

import java.util.List;
import net.messi.earlyadmin.pojo.EarlyshopEvaluateGoods;
import net.messi.earlyadmin.pojo.EarlyshopEvaluateGoodsExample;
import org.apache.ibatis.annotations.Param;

public interface EarlyshopEvaluateGoodsMapper {
    int countByExample(EarlyshopEvaluateGoodsExample example);

    int deleteByExample(EarlyshopEvaluateGoodsExample example);

    int insert(EarlyshopEvaluateGoods record);

    int insertSelective(EarlyshopEvaluateGoods record);

    List<EarlyshopEvaluateGoods> selectByExampleWithBLOBs(EarlyshopEvaluateGoodsExample example);

    List<EarlyshopEvaluateGoods> selectByExample(EarlyshopEvaluateGoodsExample example);

    int updateByExampleSelective(@Param("record") EarlyshopEvaluateGoods record, @Param("example") EarlyshopEvaluateGoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") EarlyshopEvaluateGoods record, @Param("example") EarlyshopEvaluateGoodsExample example);

    int updateByExample(@Param("record") EarlyshopEvaluateGoods record, @Param("example") EarlyshopEvaluateGoodsExample example);
}