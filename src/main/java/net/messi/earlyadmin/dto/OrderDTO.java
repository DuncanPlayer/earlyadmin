package net.messi.earlyadmin.dto;

import net.messi.earlyadmin.pojo.NideshopOrder;
import net.messi.earlyadmin.pojo.NideshopOrderGoods;

import java.io.Serializable;
import java.util.List;

public class OrderDTO implements Serializable {
    private NideshopOrder order;
    private List<NideshopOrderGoods> goodsList;

    public NideshopOrder getOrder() {
        return order;
    }

    public void setOrder(NideshopOrder order) {
        this.order = order;
    }

    public List<NideshopOrderGoods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<NideshopOrderGoods> goodsList) {
        this.goodsList = goodsList;
    }
}
