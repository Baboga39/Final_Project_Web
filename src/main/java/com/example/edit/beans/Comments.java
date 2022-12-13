package com.example.edit.beans;

import java.util.Date;

public class Comments {
    private int comment_id;
    private int article_id;
    private int user_id;
    private String comment;
    private Date create_day;

    public Comments(int comment_id, int article_id, int user_id, String comment, Date create_day) {
        this.comment_id = comment_id;
        this.article_id = article_id;
        this.user_id = user_id;
        this.comment = comment;
        this.create_day = create_day;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreate_day() {
        return create_day;
    }

    public void setCreate_day(Date create_day) {
        this.create_day = create_day;
    }

}
