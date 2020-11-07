package model;

import java.sql.Timestamp;

public class Recipe {
    private int recipeId;
    private String title;
    private String description;
    private String ingredient;
    private int difficulty;
    private float cookTime;
    private int yield;
    private Category categoryId;
    private Timestamp publishedAt;
    private Timestamp createdAt;
    private String coverImg;
    private int writerId;

    public Recipe(String title, String description, String ingredient, int difficulty, float cookTime,int yield, Category categoryId) {
        this.title = title;
        this.description = description;
        this.ingredient = ingredient;
        this.difficulty = difficulty;
        this.cookTime = cookTime;
        this.yield = yield;
        this.categoryId = categoryId;
//        this.coverImg = coverImg;
    }

    public Recipe(int recipeId, String title, String description, String ingredient, int difficulty, float cookTime, int yield,Category categoryId, Timestamp publishedAt, Timestamp createdAt, String coverImg, int writerId) {
        this.recipeId = recipeId;
        this.title = title;
        this.description = description;
        this.ingredient = ingredient;
        this.difficulty = difficulty;
        this.cookTime = cookTime;
        this.yield = yield;
        this.categoryId = categoryId;
        this.publishedAt = publishedAt;
        this.createdAt = createdAt;
        this.coverImg = coverImg;
        this.writerId = writerId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public float getCookTime() {
        return cookTime;
    }

    public void setCookTime(float cookTime) {
        this.cookTime = cookTime;
    }

    public int getYield() {
        return yield;
    }

    public void setYield(int yield) {
        this.yield = yield;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Timestamp getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Timestamp publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", ingredient='" + ingredient + '\'' +
                ", difficulty=" + difficulty +
                ", cookTime=" + cookTime +
                ", yield=" + yield +
                ", categoryId=" + categoryId +
                ", publishedAt=" + publishedAt +
                ", createdAt=" + createdAt +
                ", coverImg='" + coverImg + '\'' +
                ", writerId=" + writerId +
                '}';
    }
}
