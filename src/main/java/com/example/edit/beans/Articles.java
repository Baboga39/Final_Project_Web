package com.example.edit.beans;

import javax.xml.crypto.Data;
import java.util.Date;

public class Articles {
    private int article_id;
    private String title;
    private Date publish_date;
    private int views;
    private String abstracts;
    private String content;
    private int categories_id;
    private boolean premium;
    private int writer_id;
    private int status_id;
    private String avatar;
    private String image_content;
    private String categoryName;

    public Articles(int article_id, String title, Date publish_date, int views, String abstracts, String content, int categories_id, boolean premium, int writer_id, int status_id, String avatar, String image_content, String categoryName) {
        this.article_id = article_id;
        this.title = title;
        this.publish_date = publish_date;
        this.views = views;
        this.abstracts = abstracts;
        this.content = content;
        this.categories_id = categories_id;
        this.premium = premium;
        this.writer_id = writer_id;
        this.status_id = status_id;
        this.avatar = avatar;
        this.image_content = image_content;
        this.categoryName = categoryName;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCategories_id() {
        return categories_id;
    }

    public void setCategories_id(int categories_id) {
        this.categories_id = categories_id;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public int getWriter_id() {
        return writer_id;
    }

    public void setWriter_id(int writer_id) {
        this.writer_id = writer_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getImage_content() {
        return image_content;
    }

    public void setImage_content(String image_content) {
        this.image_content = image_content;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "article_id=" + article_id +
                ", title='" + title + '\'' +
                ", publish_date=" + publish_date +
                ", views=" + views +
                ", abstracts='" + abstracts + '\'' +
                ", content='" + content + '\'' +
                ", categories_id=" + categories_id +
                ", premium=" + premium +
                ", writer_id=" + writer_id +
                ", status_id=" + status_id +
                ", avatar='" + avatar + '\'' +
                ", image_content='" + image_content + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
