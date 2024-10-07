package com.tcc.tccmecanico;

import android.content.Context;

import java.sql.PreparedStatement;

public class UsuarioCrud {


     public static int InserirUsuario (Usuario usuario, Context ctx){

          int resposta = 0;

          try{
               PreparedStatement pst = conexaoBanco.conectar(ctx).prepareStatement(
                       sql :"Insert Into Mecanico( nome, telefone , cpf , atendimento , usuario_id , statusMecanico)" + "values (?,?,?,?,?,?)");
          }




     }
}
