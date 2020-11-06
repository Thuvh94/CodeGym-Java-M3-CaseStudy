package model;

public class CookStep {
    private int cookStepId;
    private int recipeId;
    private String stepName;
    private String textContent;

    public CookStep() {
    }

    public CookStep(int cookStepId, int recipeId, String stepName, String textContent) {
        this.cookStepId = cookStepId;
        this.recipeId = recipeId;
        this.stepName = stepName;
        this.textContent = textContent;
    }

    public int getCookStepId() {
        return cookStepId;
    }

    public void setCookStepId(int cookStepId) {
        this.cookStepId = cookStepId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }
}
