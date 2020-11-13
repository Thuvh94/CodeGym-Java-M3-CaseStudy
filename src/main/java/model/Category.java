package model;

import service.CategoryService;
import service.CategoryServiceImpl;

public class Category {
    private int categoryId;
    private String categoryName;
    private int recipeNumber = 0;



    public Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Category(int categoryId, String categoryName, int recipeNumber) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.recipeNumber = recipeNumber;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

    public void setRecipeNumber(int recipeNumber) {
        this.recipeNumber = recipeNumber;
    }

    public int getRecipeNumber() {
        return recipeNumber;
    }
}
