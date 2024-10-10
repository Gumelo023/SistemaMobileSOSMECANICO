package com.tcc.tccmecanico;

import android.content.Context;

import java.sql.PreparedStatement;

public class UsuarioCrud {

    public static int InserirUsuario (Usuario usuario, Context ctx){

        int resposta = 0;

        try {
            PreparedStatement pst = Conexao.conectar(ctx).prepareStatement(
                    "Insert Into Usuario (nome, email, senha)" + "values (?,?,?)");

            pst.setString(1, Usuario.getNome());
            pst.setString(1, Usuario.getEmail());
            pst.setString(1, Usuario.getSenha());

            resposta = pst.executeUpdate();
        } catch (Exception e){
            e.getMessage();
        }
  return resposta;
    }


}
