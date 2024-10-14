package com.tcc.tccmecanico;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import android.os.AsyncTask;
import android.content.Intent;
import android.os.Bundle;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class FormLogin extends AppCompatActivity {


     EditText loginEmail, loginPassword;
     TextView signupRedirectText;
     Button loginbutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);


        loginEmail = findViewById(R.id.login_email);
        loginPassword = findViewById(R.id.login_password);
        loginbutton = findViewById(R.id.login_button);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email =
                        loginEmail.getText().toString().trim();
                String password =
                        loginPassword.getText().toString().trim();
                if (!email.isEmpty() &&
                        !password.isEmpty()) {
                    new LoginTask().execute(email, password);
                } else {
                    Toast.makeText(FormLogin.this, "Por favor, preencha todos os campos.", Toast.LENGTH_LONG).show();
                }
            }
      });
    }
    private class LoginTask extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... params) {
            String nome = params[0];
            String email = params[1];
            String senha = params[2];

         //   String url =
          //          "jdbc:jtds:sqlserver://192.168.0.24;databaseName=Banco_Android";
         //   String user = "sa";
         //   String pass = "@ITB123456";
            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver");
                Connection connection =
                        DriverManager.getConnection("jdbc:jtds:sqlserver://172.19.0.219;" +
                                "databaseName=bd_sosmecanico;user=sa;password=@ITB123456");
                String query = "SELECT * FROM Usuario WHERE nome = ? AND email = ? AND senha = ?";
                PreparedStatement preparedStatement =
                        connection.prepareStatement(query);
                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, senha);
                ResultSet resultSet =
                        preparedStatement.executeQuery();
                boolean validLogin = resultSet.next();
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return validLogin;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }



        @Override
        protected void onPostExecute(Boolean success) {
            if (success) {

                // Login bem-sucedido, redireciona para a Home
                Toast.makeText(FormLogin.this, "Login bem-sucedido!",
                        Toast.LENGTH_LONG).show();

                loginbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(FormLogin.this, MenuLateral.class);
                        startActivity(intent);
                        //startActivity(new Intent(FormLogin.this,
                        //       MenuLateral.class));
                       // finish();
                    }
                });

            } else {

                Toast.makeText(FormLogin.this, "Nome, e-mail ou senha incorretos.", Toast.LENGTH_LONG).show();
            }
        }

    }


                }

