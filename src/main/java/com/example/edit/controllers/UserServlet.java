package com.example.edit.controllers;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.edit.Utils.ServletUtils;
import com.example.edit.beans.User;
import com.example.edit.models.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "UserServlet", value = "/User/*")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        switch (path) {
            case "/Register":
                ServletUtils.forward("/views/ViewUser/Register.jsp",request,response);
                break;
            case "/IsAvailable":
                String username = request.getParameter("user");
                boolean isAvailable = UserModel.checkByUserName(username);

                PrintWriter out = response.getWriter();
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");

                out.print(isAvailable);
                out.flush();
                break;
            case "/Login":
                ServletUtils.forward("/views/ViewUser/Login.jsp",request,response);
                break;
            default:
                ServletUtils.forward("/views/404.jsp", request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        switch (path) {
            case "/Register":
                registerUser(request, response);
                break;
            case "/Login":
                login(request,response);
                break;
            default:
                ServletUtils.forward("/views/404.jsp", request, response);
                break;
        }
    }
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //System.out.println(username);
        User user = UserModel.findByUserName(username);
        boolean check = UserModel.checkByUserName(username);
        //System.out.println(check);

        if(check == true)
        {
            BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
            if(result.verified)
            {
               ServletUtils.forward("/views/ViewUser/Index.jsp",request,response);
            }
            else
            {
                request.setAttribute("hashError",true);
                request.setAttribute("errorMessage","Invalid Login");
                ServletUtils.forward("/views/ViewUser/Login.jsp",request,response);
            }
        }
        else
        {
            request.setAttribute("hashError",true);
            request.setAttribute("errorMessage","Invalid Login");
            ServletUtils.forward("/views/ViewUser/Login.jsp",request,response);
        }

        ServletUtils.forward("/views/ViewUser/Login.jsp", request, response);
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rawpwd = request.getParameter("pass");

        String bcryptHashString = BCrypt.withDefaults().hashToString(12, rawpwd.toCharArray());

        String strDate = request.getParameter("dateofbirth");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date_of_birth = LocalDate.parse(strDate, df);

        String second_name = request.getParameter("namesecond");

        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        LocalDate issue_at = LocalDate.now();
        int otpExp = 1;
        int otp = 1;
        int expiration = 1;
        int roleId = 2;

        User user = new User(0,username,bcryptHashString,name,issue_at,expiration,roleId,second_name,date_of_birth,email,otp,otpExp);
        UserModel.add(user);
        ServletUtils.forward("/views/ViewUser/Register.jsp", request, response);
    }
}
