package com.example.edit.beans;

import java.util.Date;

public class Comments {
    private int commentId;
    private int articleId;
    private int userId;
    private String comment;
    private Date createDay;

    public Comments(int commentId, int articleId, int userId, String comment, Date createDay) {
        this.commentId = commentId;
        this.articleId = articleId;
        this.userId = userId;
        this.comment = comment;
        this.createDay = createDay;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateDay() {
        return createDay;
    }

    public void setCreateDay(Date createDay) {
        this.createDay = createDay;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "commentId=" + commentId +
                ", articleId=" + articleId +
                ", userId=" + userId +
                ", comment='" + comment + '\'' +
                ", createDay=" + createDay +
                '}';
    }
}
