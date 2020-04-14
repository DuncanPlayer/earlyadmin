package net.messi.earlyadmin.dto;

import net.messi.earlyadmin.pojo.NideshopComment;

import java.io.Serializable;
import java.util.List;

public class CommentDTO implements Serializable {

    private List<NideshopComment> data;

    private Integer count;

    public List<NideshopComment> getData() {
        return data;
    }

    public void setData(List<NideshopComment> data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
