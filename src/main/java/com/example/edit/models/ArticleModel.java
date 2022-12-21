package com.example.edit.models;

import com.example.edit.Utils.DbUtils;
import com.example.edit.beans.Articles;
import com.example.edit.beans.User;
import org.sql2o.Connection;

import java.util.List;

public class ArticleModel {

    public static List<Articles> findDraftArticles() {
        final String query = "select * from articles where status_id=104";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Articles.class);
        }
    }
}
