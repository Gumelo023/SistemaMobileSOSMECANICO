package com.tcc.tccmecanico;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {

    public static boolean sendEmail(String fromEmail, String subject, String messageBody) {
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
                // A senha deve ser gerenciada de forma segura
                return new PasswordAuthentication("seu_email@gmail.com", "sua_senha"); // Email do remetente e senha
            }
        });

        try {
            // Criação da mensagem
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail)); // E-mail do usuário
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(messageBody);

            // Envio da mensagem
            Transport.send(message);
            System.out.println("Email enviado com sucesso!");
            return true; // Retorna verdadeiro se o envio for bem-sucedido

        } catch (MessagingException e) {
            e.printStackTrace(); // Tratamento de erro
            return false; // Retorna falso se ocorrer um erro
        }
    }
}
