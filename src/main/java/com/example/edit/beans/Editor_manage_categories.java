package com.example.edit.beans;

public class Editor_manage_categories {
    private int id;
    private int editor_id;
    private int category_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEditor_id() {
        return editor_id;
    }

    public void setEditor_id(int editor_id) {
        this.editor_id = editor_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public Editor_manage_categories(int id, int editor_id, int category_id) {
        this.id = id;
        this.editor_id = editor_id;
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Editor_manage_categories{" +
                "id=" + id +
                ", editor_id=" + editor_id +
                ", category_id=" + category_id +
                '}';
    }
}
