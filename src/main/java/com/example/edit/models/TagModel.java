package com.example.edit.models;

import com.example.edit.Utils.DbUtils;
import com.example.edit.beans.Tag;
import com.example.edit.beans.User;
import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;

public class TagModel {
    public static List<Tag> findAll() {
        final String query = "select * from tags";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Tag.class);
        }
    }
    public static boolean checkTagById(int tags_id) {
        String query = "select * from tags where tags_id = :tags_id";
        try (Connection con = DbUtils.getConnection()) {
            List<Tag> list = con.createQuery(query)
                    .addParameter("tags_id",tags_id)
                    .executeAndFetch(Tag.class);
            if (list.size() == 0) {
                return false;
            }
            return true;
        }

    }

}
