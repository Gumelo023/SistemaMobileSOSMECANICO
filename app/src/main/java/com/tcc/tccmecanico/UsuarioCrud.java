package com.tcc.tccmecanico;

import android.content.Context;

import java.sql.PreparedStatement;
import java.sql.SQLData;

public class UsuarioCrud {


     public static int InserirUsuario (Usuario usuario, Context ctx){

          int resposta = 0;

          try{
               PreparedStatement pst = Conexao.conectar(ctx).prepareStatement(
                     SQLData:"Insert Into Mecanico( nome, telefone , cpf , atendimento , usuario_id , statusMecanico)" + "values (?,?,?,?,?,?)");

             pst.setString(parameterIndex: 1, Usuario.getNome());
              pst.setString(parameterIndex: 1, Usuario.getEmail());





          }




     }
}
