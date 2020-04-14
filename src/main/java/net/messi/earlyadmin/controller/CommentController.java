package net.messi.earlyadmin.controller;

import net.messi.earlyadmin.mapper.NideshopCommentMapper;
import net.messi.earlyadmin.pojo.NideshopComment;
import net.messi.earlyadmin.utils.DateUtil;
import net.messi.earlyadmin.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("layuiadmin/comment")
public class CommentController {

    @Autowired
    private NideshopCommentMapper commentMapper;

    @ResponseBody
    @GetMapping("/commentList")
    public JSONResult commentList(Integer page,Integer limit){
        int pageSize = (page - 1) * limit + 1000;
        List<NideshopComment> list =  commentMapper.findCommentByLimit(pageSize,limit);
        for (NideshopComment comment:list){
            comment.setDateStr(DateUtil.numToDate(Long.valueOf(comment.getAddTime()),"yyyy-MM-dd-[HH:ss:mm]"));
        }
        return JSONResult.ok(list,100);
    }


}
