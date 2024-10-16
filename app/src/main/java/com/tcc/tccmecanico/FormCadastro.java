package com.tcc.tccmecanico;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.android.material.snackbar.Snackbar;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class FormCadastro extends AppCompatActivity {
    private Button signup_voltar;
    private EditText signup_nome, signup_email, signup_password;
    private Button signup_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);

        signup_nome = findViewById(R.id.signup_nome);
        signup_email = findViewById(R.id.signup_email);
        signup_password = findViewById(R.id.signup_password);
        signup_button = findViewById(R.id.signup_button);
        signup_voltar = findViewById(R.id.signup_voltar);

        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = signup_nome.getText().toString().trim();
                String email = signup_email.getText().toString().trim();
                String senha = signup_password.getText().toString().trim();

                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                    Snackbar.make(signup_button, "Preencha todos os campos!", Snackbar.LENGTH_LONG).show();
                    return;
                }

                if (!isValidPassword(senha)) {
                    Snackbar.make(signup_button, "A senha deve ter pelo menos 6 caracteres, incluindo um número e um caractere especial!", Snackbar.LENGTH_LONG).show();
                    return;
                }

                String senhaCriptografada = encryptPassword(senha);
                UsuarioMob user = new UsuarioMob(nome, email, senhaCriptografada);

                int res = UsuarioCrud.InserirUsuario(user, getBaseContext());
                if (res <= 0) {
                    Snackbar.make(signup_button, "E-mail já cadastrado!", Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(signup_button, "Dados Cadastrados com Sucesso", Snackbar.LENGTH_LONG).show();
                    // Redireciona para a tela de login após sucesso no cadastro
                    startActivity(new Intent(FormCadastro.this, FormLogin.class));
                    finish();
                }
            }
        });

        signup_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormCadastro.this, FormLogin.class);
                startActivity(intent);
            }
        });
    }

    private boolean isValidPassword(String password) {
        String passwordPattern = "^(?=.*[0-9])(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]{6,}$";
        return Pattern.matches(passwordPattern, password);
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
