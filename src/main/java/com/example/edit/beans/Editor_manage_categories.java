package com.example.edit.beans;

public class Editor_manage_categories {
    private int id;
    private int editorId;
    private int categoryId;

    public Editor_manage_categories(int id, int editorId, int categoryId) {
        this.id = id;
        this.editorId = editorId;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEditorId() {
        return editorId;
    }

    public void setEditorId(int editorId) {
        this.editorId = editorId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
