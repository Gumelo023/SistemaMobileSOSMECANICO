package com.tcc.tccmecanico;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import android.util.Patterns;

public class FormCadastro extends AppCompatActivity {

    private Button signup_voltar;

    EditText signup_nome, signup_email, signup_password;
    Button signup_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);



        signup_nome = (EditText) findViewById(R.id.signup_nome);
        signup_email = (EditText) findViewById(R.id.signup_email);
        signup_password = (EditText) findViewById(R.id.signup_password);
        signup_button = (Button) findViewById(R.id.signup_button);

        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String nome = signup_nome.getText().toString();
                String email = signup_email.getText().toString();
                String senha = signup_password.getText().toString();


                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                    Snackbar.make(signup_button, "Preencha todos os campos!", Snackbar.LENGTH_LONG).show();
                    return;
                }


                Usuario user = new Usuario(
                        signup_nome.getText().toString(),
                        signup_email.getText().toString(),
                        signup_password.getText().toString());





                int res = UsuarioCrud.InserirUsuario(user, getBaseContext());
                if (res <=0){
                    Snackbar.make(signup_button, "E-mail já cadastrado!", Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(signup_button, "Dados Cadastrados com Sucesso", Snackbar.LENGTH_LONG).show();
                }


            }
        });

        signup_voltar = findViewById(R.id.signup_voltar);
        signup_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormCadastro.this, FormLogin.class);
                startActivity(intent);
            }
        });


    }
}
