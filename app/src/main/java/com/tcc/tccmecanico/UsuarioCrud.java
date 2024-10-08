package com.tcc.tccmecanico;

import android.content.Context;

import java.sql.PreparedStatement;
import java.sql.SQLData;

public class UsuarioCrud {


    public static int InserirUsuario(Usuario usuario, Context ctx) {

        int resposta = 0;
        String sql = "Insert into Usuario  (nome, email, senha, nivelAcesso, foto, dataCadastro, statusUsuario) values (?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = conexaoBanco.conectar(ctx).prepareStatement(sql);

            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getEmail());
            pst.setString(3, usuario.getSenha());
            pst.setString(4, usuario.getNivelAcesso());
            pst.setString(5, usuario.getFoto());
            pst.setString(6, usuario.getDataCadastro());
            pst.setString(7, usuario.getStatusUsuario());


            resposta = pst.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
        return resposta
    }






        }


    }


}

