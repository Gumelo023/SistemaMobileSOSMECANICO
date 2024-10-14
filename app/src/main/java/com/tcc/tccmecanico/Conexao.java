package com.tcc.tccmecanico;

import android.content.Context;
import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection conectar(Context testeConexaoBD) {
        Connection conn = null;
        try {
            StrictMode.ThreadPolicy politica;
            politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.56.1;" +
                    "databaseName=bd_sosmecanico;user=sa;password=@ITB123456");

        } catch (SQLException e){
            e.getMessage();

        } catch (ClassNotFoundException e){
            e.printStackTrace();

        }
        return conn;

}
}
