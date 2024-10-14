package com.tcc.tccmecanico;

import android.content.Context;

import java.sql.PreparedStatement;

public class UsuarioCrud {

    public static int InserirUsuario (UsuarioMob usuariomob, Context ctx){

        int resposta = 0;

        try {
            PreparedStatement pst = Conexao.conectar(ctx).prepareStatement(
                    "Insert Into Usuariomob (nome, email, senha, statusUsuario) " + "values (?,?,?, 'ATIVO')");
            System.out.println(usuariomob.getNome());
            pst.setString(1, usuariomob.getNome());
            pst.setString(2,
                    usuariomob.getEmail());
            pst.setString(3, usuariomob.getSenha());

            resposta = pst.executeUpdate();
            System.out.println(resposta);
        } catch (Exception e){
            e.getMessage();
        }
  return resposta;
    }


}
