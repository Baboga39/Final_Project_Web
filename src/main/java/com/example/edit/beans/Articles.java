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

    public Articles(int article_id, String title, Date publish_date, int views, String abstracts, String content,
                    int categories_id, boolean premium, int writer_id, int status_id, String avatar, String image_content) {
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
    }

    public int getArticleId() {
        return article_id;
    }

    public void setArticleId(int article_id) {
        this.article_id = article_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishDate() {
        return publish_date;
    }

    public void setPublishDate(Date publish_date) {
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

    public int getCategoriesId() {
        return categories_id;
    }

    public void setCategoriesId(int categories_id) {
        this.categories_id = categories_id;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public int getWriterId() {
        return writer_id;
    }

    public void setWriterId(int writer_id) {
        this.writer_id = writer_id;
    }

    public int getStatusId() {
        return status_id;
    }

    public void setStatusId(int status_id) {
        this.status_id = status_id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getImageContent() {
        return image_content;
    }

    public void setImageContent(String image_content) {
        this.image_content = image_content;
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
                '}';
    }
}
