package com.tcc.tccmecanico;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FormLogin extends AppCompatActivity {


    private EditText login_nome, login_email, login_password;
    private Button login_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);



            login_nome = findViewById(R.id.login_nome);
            login_email = findViewById(R.id.login_email);
            login_password = findViewById(R.id.login_password);
            login_button = findViewById(R.id.login_button);


            login_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = login_nome.getText().toString().trim();
                    String email = login_email.getText().toString().trim();
                    String password = login_password.getText().toString().trim();
                    if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                        new LoginTask().execute(name, email, password);
                    } else {
                        Toast.makeText(FormLogin.this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
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


                try {

                    Class.forName("net.sourceforge.jtds.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.56.1;"+
                            "databaseName=bd_sosmecanico;user=sa;password=@ITB123456;");
                    String query = "SELECT * FROM UsuarioMob WHERE nome = ? AND email = ? AND senha = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, nome);
                    preparedStatement.setString(2, email);
                    preparedStatement.setString(3, senha);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    boolean validLogin = resultSet.next(); // Se houver resultado, login é válido

                    resultSet.close();
                    preparedStatement.close();
                    connection.close();

                    return validLogin;
                } catch (Exception e) {
                    e.printStackTrace(); // Para depuração, mas evite expor detalhes ao usuário
                    return false;
                }
            }

            @Override
            protected void onPostExecute(Boolean success) {
                if (success) {
                    // Login bem-sucedido, redireciona para a Home
                    Toast.makeText(FormLogin.this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(FormLogin.this, MenuLateral.class));
                    finish(); // Fecha a tela de login
                } else {
                    // Falha no login
                    Toast.makeText(FormLogin.this, "Nome, e-mail ou senha incorretos.", Toast.LENGTH_SHORT).show();
                }
            }
        }


    }
