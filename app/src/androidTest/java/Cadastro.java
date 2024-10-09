import static android.app.ProgressDialog.show;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.tcc.tccmecanico.R;
import com.tcc.tccmecanico.Usuario;
import com.tcc.tccmecanico.UsuarioCrud;

public class Cadastro extends AppCompatActivity {

    EditText editNome, editEmail, editSenha;

    Button btn_cadastro;


    @Override
    Object btn_cadastrar;
    Object user = new;
    protected void onCreate(Bundle saveInstanceState){

        email id =editEmail
        senha id =editSenha

                Botão cadastro = btn_cadastro

                        if (res <=0){
                            int text;
                            Snackbar.make(btn_cadastrar, text:"Dados não inseridos!" ,  Snackbar.LENGTH_LONG)

                        }else {
                            Snackbar.make()


                            editEmail = (EditText) findViewById(R.id.editEmail);
                            editSenha = (EditText) findViewById(R.id.editSenha);
                            btn_cadastro = (Button) findViewById(R.id.btn_cadastrar);


                            @Override
                                    public void onClick (View)

                                    Usuario user = new Usuario(
                                 editEmail.getText().toString(),
                                    editSenha.getText().toString(),

                            );

                            int res = UsuarioCrud.InserirUsuario(user, getBaseContext());
                            if (res<=0) {

                                Snackbar.make(btn_cadastrar, text:
                                "Dados não inseridos!", Snackbar.LENGTH_LONG).show();
                            }else {
                                Snackbar.make(btn_cadastrar, text:
                                "Dados Cadastrados com Sucesso", Snackbar.LENGTH_LONG).show();
                            }






                            }











                        }










    }


}
