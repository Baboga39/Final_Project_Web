package com.example.edit.controllers;

import com.example.edit.Utils.ServletUtils;
import com.example.edit.beans.*;
import com.example.edit.models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
            case "/Agree":
                int id3 = 0;
                try {
                    id3 = Integer.parseInt(request.getParameter("article_id"));
                } catch (NumberFormatException e) {
                }
                Articles c3 = ArticleModel.findByIdAll(id3);
                List<Category> listCat = CategoryModel.findAllCat();
                List<Tag> listTag = ArticleModel.findTagByArtId(id3);
                request.setAttribute("tags",listTag);
                request.setAttribute("categories",listCat);
                request.setAttribute("article",c3);
                ServletUtils.forward("/views/viewEditorHome/Agree.jsp", request, response);
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
            case "/Agree":
                updateNew(request,response);
                break;
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

                break;
            default:
                ServletUtils.forward("/views/404.jsp", request, response);
                break;
        }
    }
    private void updateTagArticle(HttpServletRequest request, HttpServletResponse response) {

        int article_id = Integer.parseInt(request.getParameter("article_id"));
        Articles art = ArticleModel.findByIdAll(article_id);

        String[] tagValue = request.getParameterValues("value");
        int size = tagValue.length;
        for (int i=0 ;i<size;i++){
            Tag tag = TagArticleModel.findTagByTagName(tagValue[i]);
            int tags_id = tag.getTags_id();

            Tags_articles t = new Tags_articles(tags_id,article_id,0);
            TagArticleModel.addTagArticle(t);
        }
    }
    private void updateNew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int article_id = Integer.parseInt(request.getParameter("article_id"));
        HttpSession session = request.getSession();
        User authUser = (User) session.getAttribute("authUser");
        int editor_id = authUser.getUserId();

        Articles articles = ArticleModel.findByIdAll(article_id);
        String title = request.getParameter("title");

        Date create_date = articles.getCreate_date();
        int views = articles.getViews();
        String abstracts = articles.getAbstracts();
        String content = articles.getContent();

        java.util.Date publish_date = java.sql.Date.valueOf(request.getParameter("publish_date"));

        boolean premium = articles.isPremium();
        int writer_id = articles.getWriter_id();
        String avatar = articles.getAvatar();

        String categories_name = request.getParameter("name");

        Category category = CategoryModel.findCatByName(categories_name);
        int catetogy_id = category.getCategories_id();
        String categoriesName = request.getParameter("name");


        Articles a = new Articles(article_id,title,create_date,publish_date,views,abstracts,content,catetogy_id,premium,writer_id,101,avatar,categoriesName);
        ArticleModel.updateNews(a);

        ServletUtils.redirect("/Edit/Editor/Home", request, response);
    }

}