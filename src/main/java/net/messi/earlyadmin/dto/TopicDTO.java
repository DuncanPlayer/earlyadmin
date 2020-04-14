package net.messi.earlyadmin.dto;

import net.messi.earlyadmin.pojo.EarlyshopPrictice;
import net.messi.earlyadmin.pojo.NideshopGoods;
import net.messi.earlyadmin.pojo.NideshopGoodsGallery;

import java.io.Serializable;
import java.util.List;

public class TopicDTO implements Serializable {

    private NideshopGoods goods;

    private List<NideshopGoodsGallery> gallery;

    private List<EarlyshopPrictice> prictice;

    private String feel;

    public String getFeel() {
        return feel;
    }

    public void setFeel(String feel) {
        this.feel = feel;
    }

    public NideshopGoods getGoods() {
        return goods;
    }

    public void setGoods(NideshopGoods goods) {
        this.goods = goods;
    }

    public List<NideshopGoodsGallery> getGallery() {
        return gallery;
    }

    public void setGallery(List<NideshopGoodsGallery> gallery) {
        this.gallery = gallery;
    }

    public List<EarlyshopPrictice> getPrictice() {
        return prictice;
    }

    public void setPrictice(List<EarlyshopPrictice> prictice) {
        this.prictice = prictice;
    }
}
