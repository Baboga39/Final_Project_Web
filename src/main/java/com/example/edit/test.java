package com.example.edit;

import com.example.edit.Utils.DbUtils;
import com.example.edit.beans.Articles;
import com.example.edit.beans.Category;
import com.example.edit.beans.Tag;
import com.example.edit.beans.User;
import com.example.edit.models.ArticleModel;
import com.example.edit.models.CategoryModel;
import com.example.edit.models.TagModel;
import com.example.edit.models.UserModel;
import org.sql2o.Connection;

import java.util.List;

public class test {

    public static void main(String[] args) {
        int cout = ArticleModel.getTotalArtilceByTag(1);
        List<Articles> list = ArticleModel.getArticleByTag(1,2);
        System.out.println(cout);
        for (Articles a : list)
        {
            System.out.println(a.getAbstracts());
        }
    }
}
