package com.example.edit.beans;

import java.util.Date;

public class Articles {
    private int article_id;
    private String title;
    private Date publish_date;
    private int views;
    private String astract;
    private  String content;
    private int category_id;
    private boolean prenium;
    private int writter_id;
    private int status_id;
    private String image;
    private String image_conent;

    public Articles(int article_id, String title, Date publish_date, int views, String astract, String content, int category_id, boolean prenium, int writter_id, int status_id, String image, String image_conent) {
        this.article_id = article_id;
        this.title = title;
        this.publish_date = publish_date;
        this.views = views;
        this.astract = astract;
        this.content = content;
        this.category_id = category_id;
        this.prenium = prenium;
        this.writter_id = writter_id;
        this.status_id = status_id;
        this.image = image;
        this.image_conent = image_conent;
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

    public String getAstract() {
        return astract;
    }

    public void setAstract(String astract) {
        this.astract = astract;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public boolean isPrenium() {
        return prenium;
    }

    public void setPrenium(boolean prenium) {
        this.prenium = prenium;
    }

    public int getWritter_id() {
        return writter_id;
    }

    public void setWritter_id(int writter_id) {
        this.writter_id = writter_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage_conent() {
        return image_conent;
    }

    public void setImage_conent(String image_conent) {
        this.image_conent = image_conent;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "article_id=" + article_id +
                ", title='" + title + '\'' +
                ", publish_date=" + publish_date +
                ", views=" + views +
                ", astract='" + astract + '\'' +
                ", content='" + content + '\'' +
                ", category_id=" + category_id +
                ", prenium=" + prenium +
                ", writter_id=" + writter_id +
                ", status_id=" + status_id +
                ", image='" + image + '\'' +
                ", image_conent='" + image_conent + '\'' +
                '}';
    }
}
