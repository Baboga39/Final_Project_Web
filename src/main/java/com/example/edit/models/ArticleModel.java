package com.example.edit.models;

import com.example.edit.Utils.DbUtils;
import com.example.edit.beans.*;
import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;

public class ArticleModel {
    public  static List<Articles> findAll(){
        final String query="SELECT articles.*, second_name FROM articles " +
                "INNER JOIN users ON articles.writer_id = users.user_id";
        try(Connection con = DbUtils.getConnection()){
            return con.createQuery(query)
                    .executeAndFetch(Articles.class);
        }
    }
    public static List<Articles> findDraftArticles() {
        final String query = "SELECT articles.article_id,articles.create_date,articles.title,articles.publish_date,articles.views," +
                "articles.abstracts,articles.categoryName,users.second_name,articles.premium\n" +
                "FROM users INNER JOIN articles on users.user_id=articles.writer_id  WHERE  status_id=104";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Articles.class);
        }
    }
    public static List<Articles> findDraftEditorManage(int user_id){
        final String query = " SELECT users.second_name,articles.* FROM users INNER JOIN articles " +
                "ON users.user_id=articles.writer_id INNER JOIN editor_manage_categories " +
                "ON articles.categories_id=editor_manage_categories.category_id " +
                "WHERE editor_manage_categories.editor_id= :user_id AND status_id=104";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("user_id",user_id)
                    .executeAndFetch(Articles.class);
        }
    }
    public static List<Articles> findArticleByStatus2(int status_id, int writer_id){
        final String query = "SELECT articles.article_id,articles.create_date,articles.title,articles.publish_date,articles.views," +
                "articles.abstracts,articles.categoryName,users.second_name,articles.premium\n" +
                "FROM users INNER JOIN articles on users.user_id=articles.writer_id  " +
                "WHERE articles.status_id= :status_id AND articles.writer_id= :writer_id";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("status_id",status_id)
                    .addParameter("writer_id",writer_id)
                    .executeAndFetch(Articles.class);
        }
    }
    public static Articles findById(int article_id) {
        final String query = "select * from articles where article_id = :article_id  and status_id= 102";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .addParameter("article_id", article_id)
                    .executeAndFetch(Articles.class);
            if (list.size() == 0){
                return null;
            }
            return list.get(0);
        }
    }
    public static Articles findByIdAll(int article_id) {
        final String query = "select * from articles where article_id = :article_id";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .addParameter("article_id", article_id)
                    .executeAndFetch(Articles.class);
            if (list.size() == 0){
                return null;
            }
            return list.get(0);
        }
    }
    //L???y id b??i vi???t max
    public static Articles findArtByMaxID(){
        final String query = "SELECT max(article_id) as article_id FROM articles " ;
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .executeAndFetch(Articles.class);
            if (list.size() == 0){
                return null;
            }
            return list.get(0);
        }
    }
    //L???y b??i vi???t ????? ph??n trang theo Tag
    public static List<Articles> getArticleByTag(int tags_id ,int index){
        final String query = "SELECT articles.article_id,articles.title,articles.publish_date,articles.views,articles.abstracts,articles.content,articles.categories_id,articles.premium,articles.writer_id,articles.status_id,articles.avatar,articles.categoryName FROM tags INNER JOIN tags_articles  ON tags.tags_id = tags_articles.tags_id  INNER JOIN articles on tags_articles.article_id = articles.article_id WHERE tags.tags_id = :tags_id  and status_id= 102 LIMIT :index,6 ";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .addParameter("tags_id", tags_id)
                    .addParameter("index",index)
                    .executeAndFetch(Articles.class);
            if (list.size() == 0){
                return null;
            }
            return list;
        }
    }
    public static List<Articles> getArticleByTagToPre(int tags_id ,int index){
        final String query = "SELECT articles.article_id,articles.title,articles.publish_date,articles.views,articles.abstracts,articles.content,articles.categories_id,articles.premium,articles.writer_id,articles.status_id,articles.avatar,articles.categoryName FROM tags INNER JOIN tags_articles  ON tags.tags_id = tags_articles.tags_id  INNER JOIN articles on tags_articles.article_id = articles.article_id WHERE tags.tags_id = :tags_id  and status_id= 102 ORDER BY premium DESC  LIMIT :index,6 ";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .addParameter("tags_id", tags_id)
                    .addParameter("index",index)
                    .executeAndFetch(Articles.class);
            if (list.size() == 0){
                return null;
            }
            return list;
        }
    }
    //L???y t???ng s??? b??i vi???t ????? ph??n trang theo Tag
    public static int getTotalArtilceByTag(int tags_id) {
        final String query = "SELECT articles.article_id,articles.title,articles.publish_date,articles.views,articles.abstracts,articles.content,articles.categories_id,articles.premium,articles.writer_id,articles.status_id,articles.avatar,articles.categoryName FROM tags INNER JOIN tags_articles  ON tags.tags_id = tags_articles.tags_id  INNER JOIN articles on tags_articles.article_id = articles.article_id WHERE tags.tags_id = :tags_id  and status_id= 102";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list=  con.createQuery(query)
                    .addParameter("tags_id",tags_id)
                    .executeAndFetch(Articles.class);
            return list.size();
        }
    }
    public static List<Articles> findRand5SameCat(int article_id){
        final String query = "SELECT * FROM articles WHERE categories_id=" +
                "(SELECT categories_id FROM articles WHERE article_id= :article_id) AND status_id=102 ORDER BY RAND() LIMIT 5";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .addParameter("article_id", article_id)
                    .executeAndFetch(Articles.class);
            if (list.size() == 0){
                return null;
            }
            return list;
        }
    }
    public static List<Tag> findTagByArtId(int article_id){
        final String query = "SELECT tags.tags_id, tags.`value` from tags INNER JOIN tags_articles ON tags.tags_id=tags_articles.tags_id WHERE tags_articles.article_id= :article_id";
        try (Connection con = DbUtils.getConnection()) {
            List<Tag> list = con.createQuery(query)
                    .addParameter("article_id", article_id)
                    .executeAndFetch(Tag.class);
            if (list.size() == 0){
                return null;
            }
            return list;
        }
    }
    public static List<Tag> findTagByArtIdKhoa(int article_id){
        final String query = "SELECT tags.tags_id, tags.`value`,article_id from tags INNER JOIN tags_articles ON tags.tags_id=tags_articles.tags_id WHERE tags_articles.article_id= :article_id";
        try (Connection con = DbUtils.getConnection()) {
            List<Tag> list = con.createQuery(query)
                    .addParameter("article_id", article_id)
                    .executeAndFetch(Tag.class);
            if (list.size() == 0){
                return null;
            }
            return list;
        }
    }
    public static User findAuthor(int article_id) {
        final String query = "SELECT users.second_name FROM articles INNER JOIN users " +
                "ON articles.writer_id=users.user_id WHERE articles.article_id= :article_id";
        try (Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(query)
                    .addParameter("article_id", article_id)
                    .executeAndFetch(User.class);
            if (list.size() == 0){
                return null;
            }
            return list.get(0);
        }
    }
    public static List<Comments> findComment(int article_id){
        final String query = "SELECT users.second_name,comment,create_date from comments " +
                "INNER JOIN users ON comments.user_id=users.user_id WHERE article_id= :article_id";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("article_id",article_id)
                    .executeAndFetch(Comments.class);
        }
    }
    public static int checkStatus( int article_id) {
        String query = "SELECT * FROM articles WHERE article_id = :article_id";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .addParameter("article_id", article_id)
                    .executeAndFetch(Articles.class);
            if (list.size() != 0) {
                if (list.get(0).getStatus_id() == 103){
                    return 3;
                }
                else {
                    return 4;
                }
            } else {
                return -1;
            }
        }
    }
    //L???y danh s??ch b??i vi???t m?? btv duy???t
    public static List<Articles> findListAgreeEditor(int editor_id){
        final String query = "SELECT articles.*,users.second_name FROM editor_manage_categories INNER JOIN articles ON editor_manage_categories.category_id=articles.categories_id INNER JOIN users ON articles.writer_id=users.user_id WHERE articles.status_id=102 AND editor_manage_categories.editor_id= :editor_id OR articles.status_id=101";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("editor_id",editor_id)
                    .executeAndFetch(Articles.class);
        }
    }

    //L???y danh s??ch b??i vi???t m?? btv t??? ch???i
    public static List<Articles> findListRefuseEditor(int editor_id){
        final String query = "SELECT articles.*, users.second_name FROM feedback INNER JOIN articles ON " +
                "feedback.article_id=articles.article_id INNER JOIN users ON articles.writer_id=users.user_id " +
                "WHERE feedback.editor_id= :editor_id";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("editor_id",editor_id)
                    .executeAndFetch(Articles.class);
        }
    }
    // L???y top 5  b??i vi???t xem nhi???u nh???t
    public static List<Articles> findTop5() {
        final String query = "SELECT * FROM articles WHERE  status_id= 102 ORDER BY views DESC LIMIT 0,5 ";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Articles.class);
        }
    }
    // L???y top 10 b??i vi???t xem nhi???u nh???t  k??? t??? 5 c??i tr??n
    public static List<Articles> findTop10() {
        final String query = "SELECT * FROM articles where  status_id= 102 ORDER BY views DESC LIMIT 5,5  ";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Articles.class);
        }
    }
    //T??m top 4 b??i vi???t n???i b???t nh???t trong tu???n k??? t??? top 3
    public static List<Articles> findTop4() {
        final String query = "SELECT * FROM articles WHERE publish_date  >= DATE_SUB(CURRENT_DATE(), INTERVAL 10080 MINUTE) and status_id= 102 ORDER BY views DESC LIMIT 3,4";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Articles.class);
        }
    }
    //T??m top 3 b??i vi???t n???i b???t nh???t trong tu???n k??? t??? top 1
    public static List<Articles> findTop3() {
        final String query = "SELECT * FROM articles WHERE publish_date  >= DATE_SUB(CURRENT_DATE(), INTERVAL 10080 MINUTE) and status_id= 102 ORDER BY views DESC LIMIT 1,2" ;
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Articles.class);
        }
    }
    public static Articles fin1() {
        final String query = "SELECT * FROM articles WHERE publish_date  >= DATE_SUB(CURRENT_DATE(), INTERVAL 10080 MINUTE) and status_id= 102 ORDER BY views DESC";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .executeAndFetch(Articles.class);
            return  list.get(0);
        }
    }
    public static List<Articles> findTop3Admin() {
        final String query = "SELECT * FROM articles WHERE publish_date  >= DATE_SUB(CURRENT_DATE(), INTERVAL 10080 MINUTE) and status_id= 102 ORDER BY views DESC LIMIT 0,3" ;
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Articles.class);
        }
    }
    public static Articles find1New() {
        final String query = "SELECT * FROM articles WHERE publish_date <=CURRENT_DATE() AND  status_id= 102 ORDER BY publish_date DESC";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .executeAndFetch(Articles.class);
            return  list.get(0);
        }
    }
    // Top 4 b??i vi???t m???i nh???t k??? t b??i 1
    public static List<Articles> findTop5New() {
        final String query = "SELECT *  FROM articles WHERE  publish_date <=CURRENT_DATE()  and status_id= 102 ORDER BY publish_date DESC LIMIT 1,4";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Articles.class);
        }
    }
    // Top 1 b??i vi???t n???i b???t nh???t trong tu???n qua

    public static List<Articles> get5ArticleNewinWeek() {
        final String query = "SELECT *  FROM articles WHERE publish_date <=CURRENT_DATE()  and status_id= 102 ORDER BY publish_date DESC LIMIT 0,5";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Articles.class);

        }
    }
    public static List<Articles> get5ArticleNewinWeekNext() {
        final String query = "SELECT *  FROM articles WHERE publish_date <=CURRENT_DATE()  and status_id= 102 ORDER BY publish_date DESC LIMIT 6,5";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Articles.class);
        }
    }
    //Top 5 b??i vi???t m???i nh???t k??? t??? c??i th??? 5
    public static List<Articles> findTop5NewNext() {
        final String query = "SELECT *\n" +
                "FROM\n" +
                "               articles\n" +
                "                WHERE\n" +
                "                    publish_date <=CURRENT_DATE() and status_id= 102 \n" +
                "                ORDER BY publish_date DESC\n" +
                "                LIMIT 5,5";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Articles.class);
        }
    }

    public static int getAllCate() {
        final String query = "SELECT * FROM categories ";
        try (Connection con = DbUtils.getConnection()) {
            List<Category> list = con.createQuery(query)
                    .executeAndFetch(Category.class);
            return  list.size();
        }
    }
    public static int getAllArticle() {
        final String query = "SELECT * FROM articles ";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .executeAndFetch(Articles.class);
            return  list.size();
        }
    }
    public static int getAllTag() {
        final String query = "SELECT * FROM tags ";
        try (Connection con = DbUtils.getConnection()) {
            List<Tag> list = con.createQuery(query)
                    .executeAndFetch(Tag.class);
            return  list.size();
        }
    }
    public static int getAllUser() {
        final String query = "SELECT * FROM users ";
        try (Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(query)
                    .executeAndFetch(User.class);
            return  list.size();
        }
    }
    public static int getAllCateAdmin() {
        final String query = "SELECT * FROM categories ";
        try (Connection con = DbUtils.getConnection()) {
            List<Category> list = con.createQuery(query)
                    .executeAndFetch(Category.class);
            return  list.size();
        }
    }
    // T????ng t??? h??m d?????i, c?? th??m list Tag
    public static List<Articles>  findTopCateTag(int categories_id)
    {
        final String query="SELECT articles.article_id,articles.title,articles.abstracts,articles.publish_date," +
                "articles.categoryName,articles.views,tags.`value`, articles.avatar FROM tags INNER JOIN tags_articles ON " +
                "tags.tags_id=tags_articles.tags_id INNER JOIN articles ON " +
                "tags_articles.article_id= articles.article_id WHERE articles.status_id=102  AND" +
                " articles.categories_id= :categories_id AND articles.views=(SELECT Max(views) FROM articles " +
                "WHERE articles.status_id=102  AND articles.categories_id= :categories_id) ORDER BY articles.views";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("categories_id",categories_id)
                    .executeAndFetch(Articles.class);
        }
    }
    public static Articles  findTopCate(int categories_id)
    {

        final String query="SELECT * FROM articles WHERE categories_id= :categories_id  and status_id= 102 ORDER BY views DESC LIMIT 1";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .addParameter("categories_id",categories_id)
                    .executeAndFetch(Articles.class);
            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }
    //Top 5 m???i chuy??n m???c k??? t??? chuy??n m???c 1
    public static List<Articles> findTop10Cate() {
        int count = getAllCate();
        List<Articles> list= new ArrayList<>();
        for(int i= 1 ; i<= 5;i++)
        {
            list.add(findTopCate(i));
        }
        return list;
    }
    //Top 10 chuy??n m???c k??? t??? chuy??n m???c 5
    public static List<Articles> findTop10CateNext() {
        int count = getAllCate();
        List<Articles> list= new ArrayList<>();
        for(int i= 6 ; i<= 10 ;i++)
        {
            list.add(findTopCate(i));
        }
        return list;
    }
    // T??m ki???m theo Search
    public static List<Articles> findSearch(String text) {
        final String query = "SELECT * FROM articles WHERE MATCH(title,content,abstracts) AGAINST(:text)  and status_id= 102" ;
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("text",text)
                    .executeAndFetch(Articles.class);
        }
    }
    // L???y t???ng b??i vi???t khi t??m ki???m t??? kh??a
    public static int getTotalArtilceBySearh(String text) {
        final String query = "SELECT * FROM articles WHERE MATCH(title,content,abstracts) AGAINST(:text)  and status_id= 102";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list=  con.createQuery(query)
                    .addParameter("text",text)
                    .executeAndFetch(Articles.class);
            return list.size();
        }
    }
    // L???y t???t c??? b??i vi???t ???? t??m ki???m xong chia th??nh 6 b??i ????? ph??n trang
    public static List<Articles> findSearchPagging(String text, int index) {
        final String query = "SELECT * FROM articles WHERE MATCH(title,content,abstracts) AGAINST(:text)  and status_id= 102  LIMIT :index,6 ";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("text",text)
                    .addParameter("index",index)
                    .executeAndFetch(Articles.class);
        }
    }
    public static List<Articles> findSearchPaggingToPre(String text, int index) {
        final String query = " SELECT * FROM articles WHERE MATCH(title,content,abstracts) AGAINST(:text)  and status_id= 102  ORDER BY premium DESC , article_id   LIMIT :index,6";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("text",text)
                    .addParameter("index",index)
                    .executeAndFetch(Articles.class);
        }
    }
    // L???y c??c b??i vi???t theo id danh m???c
    public static List<Articles> getArticleByCate(int categories_id) {
        final String query = "SELECT * FROM articles WHERE categories_id = :categories_id   and status_id= 102";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("categories_id",categories_id)
                    .executeAndFetch(Articles.class);
        }
    }
    // L???y t?????ng s??? b??i vi???t trong 1 danh m???c
    public static int getTotalArtilceByCate(int categories_id) {
        final String query = "SELECT * FROM articles WHERE categories_id = :categories_id  and status_id= 102 ";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list=  con.createQuery(query)
                    .addParameter("categories_id",categories_id)
                    .executeAndFetch(Articles.class);
            return list.size();
        }
    }
    // L???y c??c b??i vi???t theo danh m???c ch???n ra 6 b??i ph??n th??nh 1 trang
    public static List<Articles> getArticleToPagging(int categories_id, int index) {
        final String query = "SELECT * FROM articles WHERE categories_id = :categories_id  and status_id= 102 LIMIT :index,6 ";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("categories_id",categories_id)
                    .addParameter("index",index)
                    .executeAndFetch(Articles.class);
        }
    }
    public static List<Articles> getArticleToPaggingPre(int categories_id, int index) {
        final String query = "SELECT * FROM articles WHERE categories_id = :categories_id  and status_id= 102 ORDER BY premium DESC  LIMIT :index,6 ";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("categories_id",categories_id)
                    .addParameter("index",index)
                    .executeAndFetch(Articles.class);
        }
    }
    public static List<Articles> getArticleByCateList3(int categories_id) {
        final String query = "SELECT * FROM articles WHERE categories_id = :categories_id  and status_id= 102 LIMIT 2,3 ";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("categories_id",categories_id)
                    .executeAndFetch(Articles.class);
        }
    }
    // Ki???m tra b??i vi???t c?? thu???c d???ng prenium hay kh??ng
    public static boolean checkPre( int article_id) {
        String query = "SELECT * FROM articles WHERE premium =1 AND  article_id = :article_id ";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .addParameter("article_id", article_id)
                    .executeAndFetch(Articles.class);
            if (list.size() == 0) {
                return false;
            } else {
                return true;
            }
        }
    }
    public static List<Articles> getArticlePre( int index) {
        String query = "SELECT * FROM articles WHERE premium = 1 and status_id= 102 LIMIT :index,6";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .addParameter("index",index)
                    .executeAndFetch(Articles.class);
            if (list.size() == 0) {
                return null;
            } else {
                return list;
            }
        }
    }
    public static int getTotalArticlePre( ) {
        String query = "SELECT * FROM articles WHERE premium =1 and status_id= 102 ";
        try (Connection con = DbUtils.getConnection()) {
            List<Articles> list = con.createQuery(query)
                    .executeAndFetch(Articles.class);
            return list.size();
        }
    }
    public  static  void addNews(Articles a){
        final String query = "INSERT INTO articles(title, create_date, publish_date, views, abstracts, content, " +
                "categories_id, premium, writer_id, status_id, avatar, categoryName) " +
                "VALUES (:title,:create_date,:publish_date,:views,:abstracts," +
                ":content,:categories_id,:premium,:writer_id,:status_id,:avatar,:categoryName)\n";
        try(Connection con  = DbUtils.getConnection())
        {
            con.createQuery(query)
                    .addParameter("title",a.getTitle())
                    .addParameter("create_date",a.getCreate_date())
                    .addParameter("publish_date",a.getPublish_date())
                    .addParameter("views",a.getViews())
                    .addParameter("abstracts", a.getAbstracts())
                    .addParameter("content",a.getContent())
                    .addParameter("categories_id",a.getCategories_id())
                    .addParameter("premium",a.isPremium())
                    .addParameter("writer_id",a.getWriter_id())
                    .addParameter("status_id",a.getStatus_id())
                    .addParameter("avatar",a.getAvatar())
                    .addParameter("categoryName",a.getCategoryName())
                    .executeUpdate();
        }
    }
    public static void deleteNews(int article_id)
    {
        final String query = "DELETE FROM articles WHERE article_id = :articles_id";
        try(Connection con = DbUtils.getConnection()){
            con.createQuery(query)
                    .addParameter("articles_id",article_id)
                    .executeUpdate();

        }
    }
    public  static  void updateNews(Articles a)
    {
        final String query = "UPDATE articles SET  title = :title, create_date= :create_date,publish_date = :publish_date, " +
                "views = :views, abstracts = :abstracts, content = :content, categories_id = :categories_id, " +
                "premium = :premium, writer_id = :writer_id, status_id = :status_id, avatar = :avatar, " +
                "categoryName = :categoryName WHERE article_id = :article_id \n";
        try(Connection con  = DbUtils.getConnection())
        {
            con.createQuery(query)
                    .addParameter("article_id",a.getArticle_id())
                    .addParameter("title",a.getTitle())
                    .addParameter("create_date",a.getCreate_date())
                    .addParameter("publish_date",a.getPublish_date())
                    .addParameter("views",a.getViews())
                    .addParameter("abstracts", a.getAbstracts())
                    .addParameter("content",a.getContent())
                    .addParameter("categories_id",a.getCategories_id())
                    .addParameter("premium",a.isPremium())
                    .addParameter("writer_id",a.getWriter_id())
                    .addParameter("status_id",a.getStatus_id())
                    .addParameter("avatar",a.getAvatar())
                    .addParameter("categoryName",a.getCategoryName())
                    .executeUpdate();
        }
    }
    public static List<Articles> findDraft(){
        final String query = "SELECT users.second_name,articles.* FROM users INNER JOIN articles\n" +
                "                ON users.user_id=articles.writer_id INNER JOIN editor_manage_categories\n" +
                "                ON articles.categories_id=editor_manage_categories.category_id\n" +
                "                WHERE status_id=104 OR status_id=101";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .executeAndFetch(Articles.class);
        }
    }
    public static void UpdateDraft(int article_id)
    {
        final String query = "Update articles Set status_id = 102 WHERE article_id = :article_id";
        try(Connection con = DbUtils.getConnection()){
            con.createQuery(query)
                    .addParameter("article_id",article_id)
                    .executeUpdate();
        }
    }
    public static void DeleteArtByIdCate(int categories_id)
    {
        final String query = "DELETE FROM articles WHERE categories_id = :categories_id";
        try(Connection con = DbUtils.getConnection()){
            con.createQuery(query)
                    .addParameter("categories_id",categories_id)
                    .executeUpdate();
        }
    }
    public static List<Articles> getArticleByCateId(int categories_id) {
        final String query = "SELECT * FROM articles WHERE categories_id = :categories_id";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("categories_id",categories_id)
                    .executeAndFetch(Articles.class);
        }
    }
    public static void DeleteArtByIdUser(int writer_id)
    {
        final String query = "DELETE FROM articles WHERE writer_id = :writer_id";
        try(Connection con = DbUtils.getConnection()){
            con.createQuery(query)
                    .addParameter("writer_id",writer_id)
                    .executeUpdate();
        }
    }
    public static List<Articles> findByUserId(int writer_id){
        final String query = "SELECT * FROM articles WHERE writer_id = :writer_id";
        try (Connection con = DbUtils.getConnection()) {
            return con.createQuery(query)
                    .addParameter("writer_id",writer_id)
                    .executeAndFetch(Articles.class);
        }
    }
}
