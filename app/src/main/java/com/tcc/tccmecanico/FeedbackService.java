package com.tcc.tccmecanico;

import android.content.Context;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FeedbackService {

    public static void inserirFeedback(Context context, String assunto, String mensagem) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexao.conectar(context); // Usando a classe de conexão existente
            String sql = "INSERT INTO feedback (assunto, mensagem) VALUES (?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, assunto);
            stmt.setString(2, mensagem);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Você pode substituir isso por um log mais robusto
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Tratamento de erro ao fechar
            }
        }
    }
}
