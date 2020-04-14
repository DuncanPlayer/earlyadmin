package net.messi.earlyadmin.dto;

import net.messi.earlyadmin.VO.MaterialVO;
import net.messi.earlyadmin.pojo.EarlyshopMaterial;

import java.io.Serializable;
import java.util.List;

public class MaterialListDTO implements Serializable {

    private List<EarlyshopMaterial> materials;

    private List<MaterialVO> filterCategory;

    public List<EarlyshopMaterial> getMaterials() {
        return materials;
    }

    public void setMaterials(List<EarlyshopMaterial> materials) {
        this.materials = materials;
    }

    public List<MaterialVO> getFilterCategory() {
        return filterCategory;
    }

    public void setFilterCategory(List<MaterialVO> filterCategory) {
        this.filterCategory = filterCategory;
    }
}
