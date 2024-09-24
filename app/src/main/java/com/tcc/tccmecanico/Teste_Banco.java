package com.tcc.tccmecanico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Teste_Banco extends AppCompatActivity {




    TextView BancoTeste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_banco);

        Connection conn = Conexao.conectar(Teste_Banco;Teste_Banco.this);
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