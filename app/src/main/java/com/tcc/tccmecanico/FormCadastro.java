package com.tcc.tccmecanico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;


public class FormCadastro extends AppCompatActivity {


    private EditText signupEmail, signupPassword, signupNome;
    private Button signupButton;
    private TextView loginRedirectText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);

        signupNome = (EditText) findViewById(R.id.signup_nome);
        signupEmail = (EditText) findViewById(R.id.signup_email);
        signupPassword = (EditText) findViewById(R.id.signup_password);
        signupButton = (Button) findViewById(R.id.signup_button);
        loginRedirectText = findViewById(R.id.loginRedirectText);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = signupNome.getText().toString();
                String email =signupEmail.getText().toString();
                String senha = signupPassword.getText().toString();
                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                    Snackbar.make(loginRedirectText, "Preencha todos os campos!",
                            Snackbar.LENGTH_LONG).show();
                    return;
                }

                Usuario user = new Usuario(
                        signupNome.getText().toString(),
                        signupEmail.getText().toString(),
                        signupPassword.getText().toString()
                );

                int res = UsuarioCrud.InserirUsuario(user, getBaseContext());
                if (res <=0){
                    Snackbar.make(signupButton, "E-mail já cadastrado", Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(signupButton, "Dados Cadastrados com Sucesso", Snackbar.LENGTH_LONG).show();
                }

            }
        });



        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FormCadastro.this, FormLogin.class));
            }
        });
    }

    }

