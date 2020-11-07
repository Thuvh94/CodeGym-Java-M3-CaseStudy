package model;

import java.sql.Timestamp;

public class Recipe {
    private int recipeId;
    private String title;
    private String description;
    private String ingredient;
    private int difficulty;
    private float prepareTime;
    private float cookTime;
    private float waitingTime;
    private int yield;
    private String equipment;
    private Category categoryId;
    private Timestamp publishedAt;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String coverImg;
    private int status;
    private int writerId;

    public Recipe(String title, String description, String ingredient, int difficulty, float prepareTime, float cookTime, float waitingTime, int yield, String equipment, Category categoryId) {
        this.title = title;
        this.description = description;
        this.ingredient = ingredient;
        this.difficulty = difficulty;
        this.prepareTime = prepareTime;
        this.cookTime = cookTime;
        this.waitingTime = waitingTime;
        this.yield = yield;
        this.equipment = equipment;
        this.categoryId = categoryId;
//        this.coverImg = coverImg;
    }

    public Recipe(int recipeId, String title, String description, String ingredient, int difficulty, float prepareTime, float cookTime, float waitingTime, int yield, String equipment, Category categoryId, Timestamp publishedAt, Timestamp createdAt, Timestamp updatedAt, String coverImg, int status, int writerId) {
        this.recipeId = recipeId;
        this.title = title;
        this.description = description;
        this.ingredient = ingredient;
        this.difficulty = difficulty;
        this.prepareTime = prepareTime;
        this.cookTime = cookTime;
        this.waitingTime = waitingTime;
        this.yield = yield;
        this.equipment = equipment;
        this.categoryId = categoryId;
        this.publishedAt = publishedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.coverImg = coverImg;
        this.status = status;
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

    public float getPrepareTime() {
        return prepareTime;
    }

    public void setPrepareTime(float prepareTime) {
        this.prepareTime = prepareTime;
    }

    public float getCookTime() {
        return cookTime;
    }

    public void setCookTime(float cookTime) {
        this.cookTime = cookTime;
    }

    public float getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(float waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getYield() {
        return yield;
    }

    public void setYield(int yield) {
        this.yield = yield;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
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

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
                ", prepareTime=" + prepareTime +
                ", cookTime=" + cookTime +
                ", waitingTime=" + waitingTime +
                ", yield=" + yield +
                ", equipment='" + equipment + '\'' +
                ", categoryId=" + categoryId +
                ", publishedAt=" + publishedAt +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", coverImg='" + coverImg + '\'' +
                ", status=" + status +
                ", writerId=" + writerId +
                '}';
    }
}
