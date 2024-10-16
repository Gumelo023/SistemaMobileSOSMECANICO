package com.tcc.tccmecanico;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import android.content.Context;

public class EmailSender {
    public static boolean sendEmail(Context ctx, String subject, String messageBody) {
        try {
            UsuarioMob usuario = Conexao.obterLogado(ctx); // Usando o método obterLogado da classe Conexao
            if (usuario == null) {
                System.out.println("Usuário não encontrado");
                return false;
            }

            final String to = "contant@sosmecanico.com"; // Email do suporte

            // Configurações do SMTP
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            // Criação da sessão com autenticação
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(usuario.getEmail(), usuario.getSenha()); // Email e senha do usuário logado
                }
            });

            // Criação da mensagem
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuario.getEmail())); // Email do usuário logado como remetente
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(messageBody);

            // Envio da mensagem
            Transport.send(message);
            System.out.println("Email enviado com sucesso!");
            return true; // Retorna verdadeiro se o envio for bem-sucedido

        } catch (Exception e) {
            e.printStackTrace(); // Tratamento de erro
            return false; // Retorna falso se ocorrer um erro
        }
    }
}
