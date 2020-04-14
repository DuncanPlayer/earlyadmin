package net.messi.earlyadmin.mapper;

import java.util.List;

import net.messi.earlyadmin.pojo.EarlyshopReservationGoods;
import net.messi.earlyadmin.pojo.EarlyshopReservationGoodsExample;
import org.apache.ibatis.annotations.Param;

public interface EarlyshopReservationGoodsMapper {
    int countByExample(EarlyshopReservationGoodsExample example);

    int deleteByExample(EarlyshopReservationGoodsExample example);

    int insert(EarlyshopReservationGoods record);

    int insertSelective(EarlyshopReservationGoods record);

    List<EarlyshopReservationGoods> selectByExampleWithBLOBs(EarlyshopReservationGoodsExample example);

    List<EarlyshopReservationGoods> selectByExample(EarlyshopReservationGoodsExample example);

    int updateByExampleSelective(@Param("record") EarlyshopReservationGoods record, @Param("example") EarlyshopReservationGoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") EarlyshopReservationGoods record, @Param("example") EarlyshopReservationGoodsExample example);

    int updateByExample(@Param("record") EarlyshopReservationGoods record, @Param("example") EarlyshopReservationGoodsExample example);

    void updateIsRealToTrue(@Param("reservationId") Integer reservationId, @Param("goodsSn") String goodsSn);
}