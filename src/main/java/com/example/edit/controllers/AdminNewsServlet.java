package com.example.edit.controllers;

import com.example.edit.Utils.ServletUtils;
import com.example.edit.beans.*;
import com.example.edit.models.ArticleModel;
import com.example.edit.models.CategoryModel;
import com.example.edit.models.TagModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static java.time.LocalDate.now;

@WebServlet(name = "AdminNewsServlet", value = "/Admin/News/*")
public class AdminNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/")) {
            path = "/Index";
        }
        switch (path) {
            case "/Index":
                try {
                    List<Articles> list = ArticleModel.findAll();
                    request.setAttribute("list",list);
                    ServletUtils.forward("/views/viewAdminNews/Index.jsp",request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "/Add":
                ServletUtils.forward("/views/viewAdminNews/Add.jsp", request, response);
                break;
            default:
                ServletUtils.forward("/views/404.jsp", request, response);
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String path = request.getPathInfo();
        switch (path) {
            case "/Add":
                addNews(request, response);
                break;
            case "/Update":
                updateNews(request, response);
                break;
            default:
                ServletUtils.forward("/views/404.jsp", request, response);
                break;
        }

    }

    private void addNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ServletUtils.redirect("/Admin/News", request,response);




    }

    private void updateNews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

    }
}
