package model;

public class Comment {
    private int commentId;
    private int recipeId;
    private int writerId;
    private String content;
    private String commentParentId;

    public Comment() {
    }

    public Comment(int commentId, int recipeId, int writerId, String content, String commentParentId) {
        this.commentId = commentId;
        this.recipeId = recipeId;
        this.writerId = writerId;
        this.content = content;
        this.commentParentId = commentParentId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentParentId() {
        return commentParentId;
    }

    public void setCommentParentId(String commentParentId) {
        this.commentParentId = commentParentId;
    }
}
