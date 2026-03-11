package com.capg.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class Player_repository {
    public static Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","Capg@123");
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
