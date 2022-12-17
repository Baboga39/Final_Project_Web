package com.example.edit.models;

import com.example.edit.Utils.DbUtils;
import com.example.edit.beans.Tag;
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

}
