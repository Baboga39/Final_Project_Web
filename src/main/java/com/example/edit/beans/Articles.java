package com.example.edit.beans;

import javax.xml.crypto.Data;
import java.util.Date;

public class Articles {
    private int articleId;
    private String title;
    private Date publishDate;
    private int views;
    private String abstracts;
    private String content;
    private int categoriesId;
    private boolean premium;
    private int writerId;
    private int statusId;
    private String avatar;
    private String imageContent;

    public Articles(int articleId, String title, Date publishDate, int views, String abstracts, String content, int categoriesId, boolean premium, int writerId, int statusId, String avatar, String imageContent) {
        this.articleId = articleId;
        this.title = title;
        this.publishDate = publishDate;
        this.views = views;
        this.abstracts = abstracts;
        this.content = content;
        this.categoriesId = categoriesId;
        this.premium = premium;
        this.writerId = writerId;
        this.statusId = statusId;
        this.avatar = avatar;
        this.imageContent = imageContent;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
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

    public int getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(int categoriesId) {
        this.categoriesId = categoriesId;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getImageContent() {
        return imageContent;
    }

    public void setImageContent(String imageContent) {
        this.imageContent = imageContent;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", publishDate=" + publishDate +
                ", views=" + views +
                ", abstracts='" + abstracts + '\'' +
                ", content='" + content + '\'' +
                ", categoriesId=" + categoriesId +
                ", premium=" + premium +
                ", writerId=" + writerId +
                ", statusId=" + statusId +
                ", avatar='" + avatar + '\'' +
                ", imageContent='" + imageContent + '\'' +
                '}';
    }
}
