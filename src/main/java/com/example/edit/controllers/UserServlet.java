package com.example.edit.controllers;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.edit.Utils.ServletUtils;
import com.example.edit.beans.Tag;
import com.example.edit.beans.User;
import com.example.edit.models.TagModel;
import com.example.edit.models.UserModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.time.LocalDate.now;

@WebServlet(name = "UserServlet", value = "/User/*")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        switch (path) {
            case "/Register":
                ServletUtils.forward("/views/ViewUser/Register.jsp", request, response);
                break;
            case "/IsAvailable":
                String username = request.getParameter("username");
                User user = UserModel.findByUsername(username);
                boolean isAvailable = (user == null);

                PrintWriter out = response.getWriter();
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");

                out.print(isAvailable);
                out.flush();
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

            default:
                ServletUtils.forward("/views/404.jsp", request, response);
                break;
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rawpwd = request.getParameter("pass");
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, rawpwd.toCharArray());

        String date = request.getParameter("dateofbirth");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate dob = LocalDate.parse(date, df);



        String secondname = request.getParameter("namesecond");

        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        LocalDate issueAt = now();

        int otpexp = 1;
        int otp = 1;
        int expiration = 1;
        int roleId = 2;
        User user = new User(0,username,bcryptHashString,name,issueAt,expiration,roleId,secondname,dob,email,otp,otpexp);
        UserModel.add(user);
        ServletUtils.forward("/views/ViewUser/Register.jsp", request, response);
    }
}
