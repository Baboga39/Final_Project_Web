package com.example.edit.controllers;

import com.example.edit.Utils.ServletUtils;
import com.example.edit.beans.Articles;
import com.example.edit.beans.Category;
import com.example.edit.beans.Tag;
import com.example.edit.models.ArticleModel;
import com.example.edit.models.CategoryModel;
import com.example.edit.models.TagModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.http.Part;
import java.io.File;

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
                List<Category> listCat = CategoryModel.findAllCat();
                request.setAttribute("categories",listCat);
                List<Tag> listTag = TagModel.findAll();
                request.setAttribute("tags",listTag);

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
            case "/Pagging":
                paggingByCate(request,response);
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
        String title = request.getParameter("title");
        Date publish_date = getCurrentDate();
        int views = 0;
        String abstracts = request.getParameter("abstracts");
        String content = request.getParameter("content");

        String categoryName = request.getParameter("name");
        Category category = CategoryModel.findCatByName(categoryName);
        int categories_id = category.getCategories_id();

        boolean premium = false;

        int writer_id = 2;
        int status_id = 104;
        String avatar = "";
        String image_content = "";

        Articles a = new Articles(0,title,publish_date,views,abstracts,content,categories_id,premium,
                writer_id,status_id,avatar,image_content,categoryName);
        ArticleModel.addNews(a);
        ServletUtils.redirect("/Post",request,response);
    }

    private void getArticleByCate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        int cateId = Integer.parseInt(cid);
        String indexPage = request.getParameter("index");
        if(indexPage==null)
        {
            indexPage="1";
        }
        int index =Integer.parseInt(indexPage);
        int indexNext = index+1;
        int indexPre = index-1;
        index = (index - 1) * 6;
        int count  = ArticleModel.getTotalArtilceByCate(cateId);
        int endPage = count/6;
        if(count  % 6!=0 ) {
            endPage++;
        }
        List<Articles> list = ArticleModel.getArticleToPagging(cateId,index);
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
        request.setAttribute("tag", index);
        request.setAttribute("indexNext", indexNext);
        request.setAttribute("indexPre", indexPre);
        request.setAttribute("EndPage",endPage);
        ServletUtils.forward("/views/viewArticlePosts/Index.jsp", request, response);
    }
    private static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }
    private void getArticleByTag(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String indexPage = request.getParameter("index");
        String tid = request.getParameter("tid");
        int tagId = Integer.parseInt(tid);
        if(indexPage==null)
        {
            indexPage="1";
        }
        int index =Integer.parseInt(indexPage);
        int indexNext = index+1;
        int indexPre = index-1;
        index = (index - 1) * 6;
        int count  = ArticleModel.getTotalArtilceByTag(tagId);
        int endPage = count/6;
        if(count  % 6!=0 ) {
            endPage++;
        }
        request.setAttribute("Day",getCurrentDate());
        List<Articles> listA = ArticleModel.getArticleByTag(tagId,index);
        request.setAttribute("listA", listA);
        request.setAttribute("tag", index);
        request.setAttribute("tid", tid);
        request.setAttribute("indexNext", indexNext);
        request.setAttribute("indexPre", indexPre);
        request.setAttribute("EndPage",endPage);
        ServletUtils.forward("/views/viewArticlePosts/SearchTag.jsp", request, response);
    }
    private void paggingByCate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String cid = request.getParameter("cid");
        String indexPage = request.getParameter("index");
        int cids =Integer.parseInt(cid);
        if(indexPage==null)
        {
            indexPage="1";
        }
        int index =Integer.parseInt(indexPage);
        int indexNext = index+1;
        int indexPre = index-1;
        index = (index - 1) * 6;
        int count  = ArticleModel.getTotalArtilceByCate(cids);
        int endPage = count/6;
        if(count  % 6!=0 ) {
            endPage++;
        }
        List<Articles> list = ArticleModel.getArticleToPagging(cids,index);
        Articles listOne = ArticleModel.findTopCate(cids);
        boolean check = CategoryModel.checkCate(cids);
        List<Articles> listT = ArticleModel.getArticleByCateList3(cids);
        List<Category> listC =CategoryModel.getCateChilds(cids);
        List<Category> listCa =CategoryModel.getCateByID(cids);
        request.setAttribute("listC", listC);
        request.setAttribute("listT", listT);
        request.setAttribute("listOne", listOne);
        request.setAttribute("check", check);
        request.setAttribute("list", list);
        request.setAttribute("listCa", listCa);
        request.setAttribute("tag", index);
        request.setAttribute("indexNext", indexNext);
        request.setAttribute("indexPre", indexPre);
        request.setAttribute("EndPage",endPage);
        ServletUtils.forward("/views/viewArticlePosts/Index.jsp", request, response);
    }
}
