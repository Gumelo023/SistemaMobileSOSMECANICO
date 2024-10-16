package com.tcc.tccmecanico;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {

    public static Connection conectar(Context testeConexaoBD) {
        Connection conn = null;
        try {
            StrictMode.ThreadPolicy politica;
            politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:jtds:sqlserver://172.19.2.197;" +
                    "databaseName=bd_sosmecanico;user=sa;password=@ITB123456");

        } catch (SQLException e){
            e.getMessage();

        } catch (ClassNotFoundException e){
            e.printStackTrace();

        }
        return conn;




    }

    public static UsuarioMob obterLogado(Context ctx) throws SQLException {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences("data", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("email", "");

        try {
            PreparedStatement pst = conectar(ctx).prepareStatement("select nome, email, senha from usuarioMob where email = ?");
            pst.setString(1, email);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                UsuarioMob usuariomob = new UsuarioMob( res.getString(1), res.getString(2), res.getString(3));

                return usuariomob;
            }
        }
        catch (Exception e) {
            return  null;
        }
        return null;
    }

}
