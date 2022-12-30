package com.example.edit.controllers;

import com.example.edit.Utils.ServletUtils;
import com.example.edit.beans.Articles;
import com.example.edit.beans.Feedback;
import com.example.edit.beans.User;
import com.example.edit.models.ArticleModel;
import com.example.edit.models.FeedbackModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EditorHomeServlet", value = "/Editor/Home/*")
public class EditorHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/")) {
            path = "/Index";
        }
        switch (path) {
            case "/Index":

                List<Articles> list = ArticleModel.findDraftArticles();
                request.setAttribute("draftArt",list);
                ServletUtils.forward("/views/viewEditorHome/Index.jsp", request, response);
                break;
            //case "/Approve":
            case "/Detail":
                int id2 = 0;
                try {
                    id2 = Integer.parseInt(request.getParameter("article_id"));
                } catch (NumberFormatException e) {
                }
                Articles c = ArticleModel.findByIdAll(id2);
                User u = ArticleModel.findAuthor(id2);
                if (c != null) {
                    request.setAttribute("User",u);
                    request.setAttribute("Articles", c);
                    ServletUtils.forward("/views/viewEditorHome/Detail.jsp", request, response);
                } else {
                    ServletUtils.redirect("/Editor/Home", request, response);
                }
                break;
            case "/Refuse":
                int article_id = Integer.parseInt(request.getParameter("article_id"));
                Articles article = ArticleModel.findByIdAll(article_id);
                request.setAttribute("article",article);
                ServletUtils.forward("/views/viewEditorHome/Refuse.jsp", request, response);
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
            case "/Approve":
                //Approve();
                break;
            case "/Refuse":
                int article_id = Integer.parseInt(request.getParameter("article_id"));
                HttpSession session = request.getSession();
                User authUser = (User) session.getAttribute("authUser");
                int editor_id = authUser.getUserId();
                String description = request.getParameter("description");

                Articles articles = ArticleModel.findByIdAll(article_id);
                String title = articles.getTitle();
                Date create_date = articles.getCreate_date();
                Date publish_date = articles.getPublish_date();
                int views = articles.getViews();
                String abstracts = articles.getAbstracts();
                String content = articles.getContent();
                int categories_id = articles.getCategories_id();
                boolean premium = articles.isPremium();
                int writer_id = articles.getWriter_id();
                String avatar = articles.getAvatar();
                String categoryName = articles.getCategoryName();

                Articles a = new Articles(article_id,title,create_date,publish_date,views,abstracts,content,categories_id,premium,writer_id,103,avatar,categoryName);
                ArticleModel.updateNews(a);

                Feedback feedback = new Feedback(0,editor_id,article_id,description);
                FeedbackModel.addFeedback(feedback);
                ServletUtils.redirect("/Edit/Editor/Home", request, response);
                break;
            default:
                ServletUtils.forward("/views/404.jsp", request, response);
                break;
        }
    }
}