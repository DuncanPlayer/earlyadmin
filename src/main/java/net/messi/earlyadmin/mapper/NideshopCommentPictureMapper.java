package net.messi.earlyadmin.mapper;

import java.util.List;

import net.messi.earlyadmin.pojo.NideshopCommentPicture;
import net.messi.earlyadmin.pojo.NideshopCommentPictureExample;
import org.apache.ibatis.annotations.Param;

public interface NideshopCommentPictureMapper {
    int countByExample(NideshopCommentPictureExample example);

    int deleteByExample(NideshopCommentPictureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NideshopCommentPicture record);

    int insertSelective(NideshopCommentPicture record);

    List<NideshopCommentPicture> selectByExample(NideshopCommentPictureExample example);

    NideshopCommentPicture selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NideshopCommentPicture record, @Param("example") NideshopCommentPictureExample example);

    int updateByExample(@Param("record") NideshopCommentPicture record, @Param("example") NideshopCommentPictureExample example);

    int updateByPrimaryKeySelective(NideshopCommentPicture record);

    int updateByPrimaryKey(NideshopCommentPicture record);
}