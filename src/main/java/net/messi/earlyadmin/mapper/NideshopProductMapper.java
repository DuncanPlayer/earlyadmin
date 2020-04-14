package net.messi.earlyadmin.mapper;

import java.util.List;

import net.messi.earlyadmin.pojo.NideshopProduct;
import net.messi.earlyadmin.pojo.NideshopProductExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopProductMapper {
    int countByExample(NideshopProductExample example);

    int deleteByExample(NideshopProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NideshopProduct record);

    int insertSelective(NideshopProduct record);

    List<NideshopProduct> selectByExample(NideshopProductExample example);

    NideshopProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NideshopProduct record, @Param("example") NideshopProductExample example);

    int updateByExample(@Param("record") NideshopProduct record, @Param("example") NideshopProductExample example);

    int updateByPrimaryKeySelective(NideshopProduct record);

    int updateByPrimaryKey(NideshopProduct record);
}