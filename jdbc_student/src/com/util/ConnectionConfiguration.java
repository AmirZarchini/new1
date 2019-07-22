package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfiguration {

    public static Connection getConnction(){

        Connection connection = null;

        try {

            Class.forName ( "com.mysql.cj.jdbc.Driver" );

            connection = DriverManager.getConnection ( "jdbc:mysql://localhost:3306/test2","root","" );


        }
        catch (Exception e){

            e.printStackTrace ();
        }
        return connection;
    }



}
