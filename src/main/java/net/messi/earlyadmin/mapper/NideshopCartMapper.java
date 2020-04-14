package net.messi.earlyadmin.mapper;

import java.util.List;

import net.messi.earlyadmin.pojo.NideshopCart;
import net.messi.earlyadmin.pojo.NideshopCartExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopCartMapper {
    int countByExample(NideshopCartExample example);

    int deleteByExample(NideshopCartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NideshopCart record);

    int insertSelective(NideshopCart record);

    List<NideshopCart> selectByExampleWithBLOBs(NideshopCartExample example);

    List<NideshopCart> selectByExample(NideshopCartExample example);

    NideshopCart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NideshopCart record, @Param("example") NideshopCartExample example);

    int updateByExampleWithBLOBs(@Param("record") NideshopCart record, @Param("example") NideshopCartExample example);

    int updateByExample(@Param("record") NideshopCart record, @Param("example") NideshopCartExample example);

    int updateByPrimaryKeySelective(NideshopCart record);

    int updateByPrimaryKeyWithBLOBs(NideshopCart record);

    int updateByPrimaryKey(NideshopCart record);
}