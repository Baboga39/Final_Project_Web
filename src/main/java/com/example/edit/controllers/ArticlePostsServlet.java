package com.example.edit.controllers;

import com.example.edit.Utils.ServletUtils;
import com.example.edit.beans.Articles;
import com.example.edit.beans.Category;
import com.example.edit.beans.Tag;
import com.example.edit.models.ArticleModel;
import com.example.edit.models.CategoryModel;
import com.example.edit.models.TagModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ArticlePostsServlet", value = "/Posts/*")
public class ArticlePostsServlet extends HttpServlet {
    private static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path = request.getPathInfo();
        if (path == null || path.equals("/")) {
            path = "/Index";
        }
        switch (path) {
            case "/Index":
                List<Articles> list = ArticleModel.findDraftArticles();
                request.setAttribute("articles", list);
                ServletUtils.forward("/views/viewArticlePosts/Index.jsp", request, response);
                break;
            case "/Search":
                String text = request.getParameter("search");
                List<Articles> listA = ArticleModel.findSearch(text);
                List<Tag> listT = TagModel.findByindex();
                request.setAttribute("Day",getCurrentDate());
                request.setAttribute("tags", listT);
                request.setAttribute("listA", listA);
                ServletUtils.forward("/views/viewArticlePosts/Search.jsp", request, response);
                break;
            default:
                ServletUtils.forward("/views/404.jsp", request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
