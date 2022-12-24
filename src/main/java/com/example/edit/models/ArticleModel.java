package com.example.edit.models;

import com.example.edit.Utils.DbUtils;
import com.example.edit.beans.Articles;
import com.example.edit.beans.Category;
import com.example.edit.beans.User;
import org.sql2o.Connection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticleModel {

    public static List<Articles> findDraftArticles() {
        final String query = "select * from articles where status_id=104";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Articles.class);
        }
    }

    public static List<Articles> findTop5() {
        final String query = "SELECT * FROM articles ORDER BY views DESC LIMIT 0,5";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Articles.class);
        }
    }

    public static List<Articles> findTop10() {
        final String query = "SELECT * FROM articles ORDER BY views DESC LIMIT 5,5";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Articles.class);
        }
    }

    public static List<Articles> findTop4() {
        final String query = "SELECT \n" +
                "    *\n" +
                "FROM\n" +
                "    articles\n" +
                "WHERE\n" +
                "    publish_date >= DATE_SUB(CURRENT_DATE(), INTERVAL 10080 MINUTE)\n" +
                "ORDER BY views DESC\n" +
                "LIMIT 4,4\n";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Articles.class);
        }
    }
    public static List<Articles> findTop3() {
        final String query = "SELECT \n" +
                "    *\n" +
                "FROM\n" +
                "    articles\n" +
                "WHERE\n" +
                "    publish_date >= DATE_SUB(CURRENT_DATE(), INTERVAL 10080 MINUTE)\n" +
                "ORDER BY views DESC\n" +
                "LIMIT 2,2\n";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Articles.class);
        }
    }
    public static List<Articles> findTop5New() {
        final String query = "SELECT *  FROM articles WHERE publish_date <=CURRENT_DATE() ORDER BY publish_date DESC LIMIT 2,4";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Articles.class);
        }
    }
    public static Articles fin1() {
        final String query = "SELECT *  FROM articles WHERE publish_date <=CURRENT_DATE() ORDER BY publish_date DESC LIMIT 5";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .executeAndFetch(Articles.class);
            return  list.get(0);
        }
    }
    public static List<Articles> findTop5NewNext() {
        final String query = "SELECT *\n" +
                "FROM\n" +
                "               articles\n" +
                "                WHERE\n" +
                "                    publish_date <=CURRENT_DATE()\n" +
                "                ORDER BY publish_date DESC\n" +
                "                LIMIT 6,5";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Articles.class);
        }
    }

    public static int getAllCate() {
        final String query = "SELECT * FROM categories";
        try (Connection con = DbUtils.getConnection()) {
            List<Category> list = con.createQuery(query)
                    .executeAndFetch(Category.class);
            return  list.size();
        }
    }

    public static Articles  findTopCate(int categories_id)
    {

        final String query="SELECT * FROM articles WHERE categories_id= :categories_id ORDER BY views DESC LIMIT 1";
        try (Connection con = DbUtils.getConnection()) {
           List<Articles> list = con.createQuery(query)
                   .addParameter("categories_id",categories_id)
                   .executeAndFetch(Articles.class);
            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }
    public static List<Articles> findTop10Cate() {
        int count = getAllCate();
        List<Articles> list= new ArrayList<>();
        for(int i= 1 ; i<= count;i++)
        {
            list.add(findTopCate(i));
        }
        return list;
    }
    public static List<Articles> findSearch(String text) {
        final String query = "SELECT * FROM articles WHERE MATCH(title,content,abstracts) AGAINST(:text)";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("text",text)
                    .executeAndFetch(Articles.class);
        }
    }
}
