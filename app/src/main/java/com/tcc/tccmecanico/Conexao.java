package com.tcc.tccmecanico;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection conectar() {
        Connection conn = null;
        try {
            StrictMode.ThreadPolicy política;
            política = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(política);
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:jtds:sqlserver://172.19.1.183" +
                    "databaseName=bd_sosmecanico;user=sa;password=@ITB123456@");

        } catch (SQLException e) {
            e.getMessage();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        return conn;

}
