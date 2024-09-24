package com.tcc.tccmecanico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Teste_Banco extends AppCompatActivity {

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





    TextView BancoTeste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_banco);

        Connection conn = Teste_Banco.conectar( Teste_Banco; Teste_Banco.this);
        BancoTeste = findViewById(R.id.BancoTeste);

        try {
            if (conn != null) {
                if (!conn.isClosed())
                    BancoTeste.setText("CONEXAO REALIZADA COM SUCESSO");
                else
                    BancoTeste.setText("A CONEXÃO ESTÁ FECHADA");
            } else {

                BancoTeste.setText("CONEXAO NULA, NÃO REALIZADA");
            }

        }catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            BancoTeste.setText("CONEXÃO FALHOU!!!\n" + ex.getMessage());
        }

    }
}