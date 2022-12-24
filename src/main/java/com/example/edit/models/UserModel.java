package com.example.edit.models;

import com.example.edit.Utils.DbUtils;
import com.example.edit.beans.Tag;
import com.example.edit.beans.User;
import org.sql2o.Connection;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

public class UserModel {

    public static void add(User c) {
        String insertSql = "INSERT INTO users (username, password, name, issue_at, expiration, role_id, second_name, date_of_birth, email, otp, otp_exp) VALUES (:username,:password,:name,:issue_at,:expiration,:role_id,:second_name,:date_of_birth,:email,:otp,:otp_exp)";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(insertSql)
                    .addParameter("username", c.getUsername())
                    .addParameter("password", c.getPassword())
                    .addParameter("name", c.getName())
                    .addParameter("issue_at", c.getIssueAt())
                    .addParameter("expiration", c.getExpiration())
                    .addParameter("role_id", c.getRole_id())
                    .addParameter("second_name", c.getSecond_name())
                    .addParameter("date_of_birth", c.getDateOfBirth())
                    .addParameter("email", c.getEmail())
                    .addParameter("otp_exp", c.getOtp_exp())
                    .addParameter("otp", c.getOtp())
                    .executeUpdate();
        }
    }

    public static void edit(String pass, String email) {

        String updateSql = "UPDATE users SET password = :password WHERE email= :email";
        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(updateSql)
                    .addParameter("password", pass)
                    .addParameter("email", email)
                    .executeUpdate();
        }

    }

    public static User findByEmail(String email) {
        final String query = "select user_id,username,password,`name`,second_name,email FROM users  where email = :email";
        try (Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(query)
                    .addParameter("email", email)
                    .executeAndFetch(User.class);
            if (list.size() == 0) {
                return null;
            }

            return list.get(0);
        }
    }


    public static User getNameUserByEmail(String email) {
        String query = "SELECT name FROM users WHERE email= :email";
        try (Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(query)
                    .addParameter("email", email)
                    .executeAndFetch(User.class);
            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }

    public static User findByUsername(String username) {
        final String query = "select * from users where username = :username";
        try (Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(query)
                    .addParameter("username", username)
                    .executeAndFetch(User.class);

            if (list.size() == 0) {
                return null;
            }

            return list.get(0);
        }
    }

    static final String ACCOUNT = "baboga12@outlook.com";
    static final String PASSWORD = "Ngochai0612";
    static final String SUBJECT = "Quên mật khẩu.";

    public static String getOtp(String email) {
        String query = "SELECT otp FROM users WHERE email= :email";
        try (Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(query)
                    .addParameter("email", email)
                    .executeAndFetch(User.class);
            if (list.size() == 0) {
                return null;
            } else {
                User a = list.get(0);
                String b = String.valueOf(a.getOtp());
                return b;
            }
        }
    }

    public static boolean checkOtp(String otp, String email) {
        String query = "SELECT otp_exp FROM users WHERE otp= :otp AND email= :email";
        try (Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(query)
                    .addParameter("otp", otp)
                    .addParameter("email", email)
                    .executeAndFetch(User.class);
            if (list.size() == 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    public static void sendMailToEmail(String email, String Content) {
        String fromEmail = ACCOUNT;
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.office365.com");
            props.put("mail.smtp.post", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.ssl.protocols", "TLSv1.2");
            Authenticator auth = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(ACCOUNT, PASSWORD);
                }
            };
            // Gui email
            Session session = Session.getInstance(props, auth);
            MimeMessage msg = new MimeMessage(session);
            // set data for mail
            msg.setFrom(new InternetAddress(fromEmail, "Hai"));
            msg.setReplyTo(InternetAddress.parse(fromEmail, false));
            msg.setText(Content, "UTF-8");
            msg.setSubject(SUBJECT, "UTF-8");
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email, false));
            Transport.send(msg);
            System.out.println("Send mail complete");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User getUserByEmail(String email) {
        String query = "SELECT name FROM users WHERE email= :email";
        try (Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(query)
                    .addParameter("email", email)
                    .executeAndFetch(User.class);
            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }

    public static boolean checkByUserName(String username) {
        String query = "select * from users where username = :username";
        try (Connection con = DbUtils.getConnection()) {
            List<User> list = con.createQuery(query)
                    .addParameter("username", username)
                    .executeAndFetch(User.class);
            if (list.size() == 0) {
                return false;
            }
            return true;
        }
    }

}
