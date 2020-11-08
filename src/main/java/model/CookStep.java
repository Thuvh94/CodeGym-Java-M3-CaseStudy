package model;

public class CookStep {
    private int cookStepId;
    private Recipe recipeId;
    private String textContent;

    public CookStep() {
    }

    public CookStep(Recipe recipeId, String textContent) {
        this.recipeId = recipeId;
        this.textContent = textContent;
    }

    public CookStep(int cookStepId, Recipe recipeId, String textContent) {
        this.cookStepId = cookStepId;
        this.recipeId = recipeId;
        this.textContent = textContent;
    }

    public int getCookStepId() {
        return cookStepId;
    }

    public void setCookStepId(int cookStepId) {
        this.cookStepId = cookStepId;
    }

    public Recipe getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Recipe recipeId) {
        this.recipeId = recipeId;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    @Override
    public String toString() {
        return "CookStep{" +
                "cookStepId=" + cookStepId +
                ", recipeId=" + recipeId +
                ", textContent='" + textContent + '\'' +
                '}';
    }
}
