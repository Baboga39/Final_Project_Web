package com.example.edit;

import com.example.edit.beans.User;
import com.example.edit.models.UserModel;

public class test {
    public static void main(String[] args) {
        String v = "1";
        String m = "ngochai06122002@gmail.com";
       boolean d= UserModel.checkOtp(v,m);
      System.out.println(d);
    }
}
