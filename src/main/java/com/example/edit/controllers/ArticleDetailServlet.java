package com.example.edit.controllers;

import com.example.edit.Utils.ServletUtils;
import com.example.edit.beans.Articles;
import com.example.edit.beans.Comments;
import com.example.edit.beans.Tag;
import com.example.edit.beans.User;
import com.example.edit.models.ArticleModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ArticleDetailServlet", value = "/Detail/*")
public class ArticleDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/")) {
            path = "/Index";
        }
        switch (path) {
            case "/Index":
                int articleID = Integer.parseInt(request.getParameter("article_id"));

                List<Articles> listRand5 = ArticleModel.findRand5SameCat(articleID);
                request.setAttribute("listRand5SameCat",listRand5);

                List<Tag> listTag = ArticleModel.findTagByArtId(articleID);
                request.setAttribute("listTag",listTag);

                List<Comments> listComment = ArticleModel.findComment(articleID);
                request.setAttribute("listComment",listComment);

                List<User> listAuthor = ArticleModel.findAuthorComment(articleID);
                request.setAttribute("listAuthor",listAuthor);

                User user = ArticleModel.findAuthor(articleID);
                Articles article = ArticleModel.findById(articleID);
                if(article==null){
                    ServletUtils.redirect("/Home", request, response);
                } else{
                    request.setAttribute("user",user);
                    request.setAttribute("article", article);
                    ServletUtils.forward("/views/viewArticleDetail/Index.jsp", request, response);
                }
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
