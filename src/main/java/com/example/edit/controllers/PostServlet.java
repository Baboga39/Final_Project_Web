package com.example.edit.controllers;

import com.example.edit.Utils.ServletUtils;
import com.example.edit.beans.Articles;
import com.example.edit.beans.Category;
import com.example.edit.models.ArticleModel;
import com.example.edit.models.CategoryModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "PostServlet", value = "/Post/*")
@MultipartConfig(
        fileSizeThreshold = 2 * 1024 * 1024,
        maxFileSize = 50 * 1024 * 1024,
        maxRequestSize = 50 * 1024 * 1024
)

public class PostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/")) {
            path = "/Index";
        }
        switch (path) {
            case "/Index":
                ServletUtils.forward("/views/viewPost/Index.jsp", request, response);
                break;
            case "/Upload":
                ServletUtils.forward("/views/viewPost/Upload.jsp", request, response);
                break;
            case "/Category":
                getArticleByCate(request,response);
                break;
            case "/Tag":
                getArticleByTag(request,response);
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
        if (path == null || path.equals("/")) {
            path = "/Index";
        }
        switch (path) {
            case "/Index":
                postArticles(request, response);
                break;
            case "/Upload":
                postUpload(request, response);
                break;
            default:
                ServletUtils.forward("/views/404.jsp", request, response);
                break;
        }
    }

    private void postUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("ProName"));

        // Collection<Part> parts = request.getParts();
        // System.out.println(parts.size());

        for (Part part : request.getParts()) {
            // System.out.println(part.getName());
            // for (String headerName : part.getHeaderNames()) {
            //   System.out.println(headerName);
            // }

            if (part.getName().equals("fuMain")) {
                String contentDisposition = part.getHeader("content-disposition");
                // System.out.println(contentDisposition);
                String[] items = contentDisposition.split(";");
                for (String s : items) {
                    String tmp = s.trim();
                    if (tmp.startsWith("filename")) {
                        int idx = tmp.indexOf("=") + 2;
                        String filename = tmp.substring(idx, tmp.length() - 1);
                    //   http://localhost:8080/Edit/image/Article/A3.jpg
                        String targetDir = this.getServletContext().getRealPath("image/Article");
                        File dir = new File(targetDir);
                        if (!dir.exists()) {
                            dir.mkdir();
                        }
                        String destination = targetDir + "/" + filename;
                        part.write(destination);
                    }
                }
            }
        }

        ServletUtils.forward("/views/viewPost/Upload.jsp", request, response);
    }
    private void postArticles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("Content");
        System.out.println(content);
        ServletUtils.forward("/views/viewPost/Index.jsp", request, response);
    }
    private void getArticleByCate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        int cateId = Integer.parseInt(cid);
        List<Articles> list = ArticleModel.getArticleByCate(cateId);
        Articles listOne = ArticleModel.findTopCate(cateId);
        boolean check = CategoryModel.checkCate(cateId);
        List<Articles> listT = ArticleModel.getArticleByCateList3(cateId);
        List<Category> listC =CategoryModel.getCateChilds(cateId);
        List<Category> listCa =CategoryModel.getCateByID(cateId);
        request.setAttribute("listC", listC);
        request.setAttribute("listT", listT);
        request.setAttribute("listOne", listOne);
        request.setAttribute("check", check);
        request.setAttribute("list", list);
        request.setAttribute("listCa", listCa);
        ServletUtils.forward("/views/viewArticlePosts/Index.jsp", request, response);
    }
    private static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }
    private void getArticleByTag(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tid = request.getParameter("tid");
        int tagId = Integer.parseInt(tid);
        request.setAttribute("Day",getCurrentDate());
        List<Articles> listA = ArticleModel.getArticleByTag(tagId);
        request.setAttribute("listA", listA);
        ServletUtils.forward("/views/viewArticlePosts/Search.jsp", request, response);
    }
}
