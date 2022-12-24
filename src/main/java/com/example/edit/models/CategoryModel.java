package com.example.edit.models;

import com.example.edit.Utils.DbUtils;
import com.example.edit.beans.Category;
import com.example.edit.beans.Tag;
import org.sql2o.Connection;

import java.util.List;

public class CategoryModel {
    public static List<Category> findAll() {
        final String query = "SELECT * FROM categories WHERE parent_id  is  null";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Category.class);
        }
    }
    public static List<Category> findAllIn() {
        final String query = "SELECT * FROM categories";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Category.class);
        }
    }
    public static List<Category> findByParentId(int parent_id) {
        final String query = "SELECT * FROM categories WHERE parent_id= :parent_id ";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("parent_id",parent_id)
                    .executeAndFetch(Category.class);
        }
    }

    public static List<Category> find5Cate() {
        final String query = "SELECT * FROM categories ORDER BY categories_id  LIMIT 0,5";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Category.class);
        }
    }
    public static List<Category> find4Cate() {
        final String query = "SELECT * FROM categories ORDER BY categories_id  LIMIT 0,4";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Category.class);
        }
    }

}
