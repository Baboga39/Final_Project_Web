package com.example.edit.models;

import com.example.edit.Utils.DbUtils;
import com.example.edit.beans.Category;
import com.example.edit.beans.Tag;
import com.example.edit.beans.User;
import org.sql2o.Connection;

import java.util.ArrayList;
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
    public static List<Category> getCateChilds(int cateId) {
        final String query = "SELECT * FROM categories WHERE parent_id = :cateId";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("cateId",cateId)
                    .executeAndFetch(Category.class);
        }
    }
    //Check xem có Category con ko
    public static boolean checkCate(int cateId) {
        String query = "SELECT * FROM categories WHERE parent_id = :cateId";
        try (Connection con = DbUtils.getConnection()) {
            List<Category> list = con.createQuery(query)
                    .addParameter("cateId", cateId)
                    .executeAndFetch(Category.class);
            if (list.size() == 0) {
                return false;
            }
            return true;
        }
    }
    public static List<Category> getCateByID(int cateId) {
        final String query = "SELECT * FROM categories WHERE categories_id = :cateId LIMIT 1";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("cateId",cateId)
                    .executeAndFetch(Category.class);
        }
    }
    public static Category findCateById(int categories_id) {
        final String query = "SELECT * FROM categories WHERE categories_id = :categories_id";
        try (Connection con = DbUtils.getConnection()) {
            List<Category> list = con.createQuery(query)
                    .addParameter("categories_id", categories_id)
                    .executeAndFetch(Category.class);

            if (list.size() == 0) {
                return null;
            }

            return list.get(0);
        }
    }
    public static void addCate(Category category)
    {
        final String query = "INSERT INTO categories (name, parent_id) VALUES (:name,:parent_id)";
        try(Connection con = DbUtils.getConnection()){
                        con.createQuery(query)
                    .addParameter("name", category.getName())
                    .addParameter("parent_id",category.getParent_id())
                    .executeUpdate();

        }
    }
    public static void updateCate(Category category)
    {
        final String query = "UPDATE categories SET  name = :name, parent_id = :parent_id WHERE categories_id = :categories_id";
        try(Connection con = DbUtils.getConnection()){
            con.createQuery(query)
                    .addParameter("categories_id",category.getCategories_id())
                    .addParameter("name", category.getName())
                    .addParameter("parent_id",category.getParent_id())
                    .executeUpdate();

        }
    }
    public static void deleteCate(int categories_id)
    {
        final String query = "DELETE FROM categories WHERE categories_id = :categories_id";
        try(Connection con = DbUtils.getConnection()){
            con.createQuery(query)
                    .addParameter("categories_id",categories_id)
                    .executeUpdate();

        }
    }


}
