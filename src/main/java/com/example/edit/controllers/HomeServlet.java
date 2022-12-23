package com.example.edit.controllers;

import com.example.edit.Utils.ServletUtils;
import com.example.edit.beans.Articles;
import com.example.edit.beans.Category;
import com.example.edit.beans.Tag;
import com.example.edit.models.ArticleModel;
import com.example.edit.models.CategoryModel;
import com.example.edit.models.TagModel;
import com.example.edit.models.UserModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/Home/*")
public class HomeServlet extends HttpServlet {
    private static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/")) {
            path = "/Index";
        }

        switch (path) {
            case "/Index":
                List<Category> listC = CategoryModel.findAll();
                List<Category> listP = CategoryModel.findByParentId(2);
                List<Tag> list = TagModel.findByindex();
                List<Articles> listtop5 = ArticleModel.findTop5();
                List<Articles> listtop10 = ArticleModel.findTop10();
                request.setAttribute("Day",getCurrentDate());
                request.setAttribute("listtop", listtop5);
                request.setAttribute("listtopnext", listtop10);
                request.setAttribute("tags", list);
                request.setAttribute("listC", listC);
                request.setAttribute("listP", listP);
                ServletUtils.forward("/views/viewHome/Index.jsp", request, response);
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
