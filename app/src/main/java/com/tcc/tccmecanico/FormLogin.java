package com.tcc.tccmecanico;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FormLogin extends AppCompatActivity {

    private EditText login_nome, login_email, login_password;
    private Button login_button;

    private TextView cadastro_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);


        login_email = findViewById(R.id.login_email);
        login_password = findViewById(R.id.login_password);
        login_button = findViewById(R.id.login_button);

        login_button.setOnClickListener(v -> {
            String email = login_email.getText().toString().trim();
            String password = login_password.getText().toString().trim();
            if ( !email.isEmpty() && !password.isEmpty()) {
                new LoginTask().execute( email, password);
                SharedPreferences sharedPreferences = getSharedPreferences("usuario", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("email", email);
                editor.apply();
                Intent it = new Intent(this, MainActivity.class);
                startActivity(it);
            } else {
                Toast.makeText(getApplicationContext(),"Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class LoginTask extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... params) {
            String email = params[0];
            String senha = params[1];

            // Criptografa a senha fornecida pelo usuário
            String senhaCriptografada = encryptPassword(senha);

            try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:jtds:sqlserver://172.19.1.58;" +
                        "databaseName=bd_sosmecanico;user=sa;password=@ITB123456;");
                String query = "SELECT * FROM UsuarioMob WHERE email = ? AND senha = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, senhaCriptografada); // Use a senha criptografada
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

        private String encryptPassword(String password) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hashedPassword = md.digest(password.getBytes());
                StringBuilder sb = new StringBuilder();
                for (byte b : hashedPassword) {
                    sb.append(String.format("%02x", b));
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
