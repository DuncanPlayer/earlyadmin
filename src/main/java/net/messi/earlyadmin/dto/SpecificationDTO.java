package net.messi.earlyadmin.dto;

import net.messi.earlyadmin.pojo.NideshopGoodsSpecification;

import java.io.Serializable;
import java.util.List;

public class SpecificationDTO implements Serializable {

    private Integer specificationId;

    private String name;

    private List<NideshopGoodsSpecification> valueList;

    public Integer getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Integer specificationId) {
        this.specificationId = specificationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NideshopGoodsSpecification> getValueList() {
        return valueList;
    }

    public void setValueList(List<NideshopGoodsSpecification> valueList) {
        this.valueList = valueList;
    }
}
