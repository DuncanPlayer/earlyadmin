package net.messi.earlyadmin.dto;


import net.messi.earlyadmin.pojo.NideshopCategory;

import java.io.Serializable;
import java.util.List;

public class CategoryDTO implements Serializable {

    private List<NideshopCategory> categoryList;

    private CurrentCategoryDTO currentCategory;

    public List<NideshopCategory> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<NideshopCategory> categoryList) {
        this.categoryList = categoryList;
    }

    public CurrentCategoryDTO getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(CurrentCategoryDTO currentCategory) {
        this.currentCategory = currentCategory;
    }
}
