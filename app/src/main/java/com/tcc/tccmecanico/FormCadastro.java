    package com.tcc.tccmecanico;

    import androidx.appcompat.app.AppCompatActivity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import com.google.android.material.snackbar.Snackbar;

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

                    UsuarioMob user = new UsuarioMob(nome, email, senha);

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
    }
