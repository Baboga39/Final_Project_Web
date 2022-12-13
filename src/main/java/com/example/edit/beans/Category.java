package com.example.edit.beans;

public class Category {
    private int category_id;
    private String name;
    private int parent_id;

    public Category(int category_id, String name, int parent_id) {
        this.category_id = category_id;
        this.name = name;
        this.parent_id = parent_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", name='" + name + '\'' +
                ", parent_id=" + parent_id +
                '}';
    }
}
