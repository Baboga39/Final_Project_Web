package com.example.edit.controllers;

import com.example.edit.Utils.ServletUtils;
import com.example.edit.beans.AccountGG;
import com.example.edit.beans.Tag;
import com.example.edit.models.TagModel;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LogingServlet", value = "/Loging/*")
public class LogingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static String GOOGLE_CLIENT_ID = "1042745399242-haj5b8r1tbkntvodjccuohp8khmrsgm7.apps.googleusercontent.com";
    public static String GOOGLE_CLIENT_SECRET = "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";
    public static String GOOGLE_REDIRECT_URI = "http://localhost:8080/Edit/Loging/Google";
    public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
    public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
    public static String GOOGLE_GRANT_TYPE = "authorization_code";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path == null || path.equals("/")) {
            path = "/Index";
        }

        switch (path) {
            case "/Google":
                try {
//                    String code=request.getParameter("code");
//                    System.out.println(code);
//                    String accessToken=  getToken(code);
//                    AccountGG usergg = getUserInfo(accessToken);
//                    System.out.println(usergg);
//                    request.setAttribute("usergg", usergg);
                    List<Tag> list = TagModel.findAll();
                    request.setAttribute("tags", list);
                    request.getRequestDispatcher("/views/viewHome/Index.jsp").forward(request,response);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
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
    public String getToken(String code) throws ClientProtocolException, IOException {
        String response = Request.Post(GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", GOOGLE_CLIENT_ID)
                        .add("client_secret", GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", GOOGLE_GRANT_TYPE).build())
                .execute()
                .returnContent()
                .asString();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response).get("access_token");
        return node.textValue();
    }

    public AccountGG getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();
        ObjectMapper mapper = new ObjectMapper();
        AccountGG AccountGoogle = mapper.readValue(response, AccountGG.class);
        return AccountGoogle;
    }
}
