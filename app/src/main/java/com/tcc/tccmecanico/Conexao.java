package com.tcc.tccmecanico;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection conectar(TesteConexaoBD testeConexaoBD) {
        Connection conn = null;
        try {
            StrictMode.ThreadPolicy politica;
            politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:jtds:sqlserver://172.18.144.1" +
                    "databaseName=bd_sosmecanico;user=SA;password=@ITB123456");

        } catch (SQLException e){
            e.getMessage();

        } catch (ClassNotFoundException e){
            e.printStackTrace();

        }
        return conn;

}
}
