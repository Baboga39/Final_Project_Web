package com.example.edit.beans;

public class Tags_articles {
    private int tag_id;
    private int article_id;

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public Tags_articles(int tag_id, int article_id) {
        this.tag_id = tag_id;
        this.article_id = article_id;
    }

    @Override
    public String toString() {
        return "Tags_articles{" +
                "tag_id=" + tag_id +
                ", article_id=" + article_id +
                '}';
    }
}
