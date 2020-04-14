package net.messi.earlyadmin.mapper;

import java.util.List;

import net.messi.earlyadmin.pojo.NideshopKeywords;
import net.messi.earlyadmin.pojo.NideshopKeywordsExample;
import net.messi.earlyadmin.pojo.NideshopKeywordsKey;
import org.apache.ibatis.annotations.Param;

public interface NideshopKeywordsMapper {
    int countByExample(NideshopKeywordsExample example);

    int deleteByExample(NideshopKeywordsExample example);

    int deleteByPrimaryKey(NideshopKeywordsKey key);

    int insert(NideshopKeywords record);

    int insertSelective(NideshopKeywords record);

    List<NideshopKeywords> selectByExample(NideshopKeywordsExample example);

    NideshopKeywords selectByPrimaryKey(NideshopKeywordsKey key);

    int updateByExampleSelective(@Param("record") NideshopKeywords record, @Param("example") NideshopKeywordsExample example);

    int updateByExample(@Param("record") NideshopKeywords record, @Param("example") NideshopKeywordsExample example);

    int updateByPrimaryKeySelective(NideshopKeywords record);

    int updateByPrimaryKey(NideshopKeywords record);
}