package it.epicode.gestione_manutenzioni.mail;



import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.hibernate.pretty.MessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject) throws MessagingException {
        sendEmail(to, subject, "Mail di spam");
    }

    public void sendEmail(String to, String subject, String body) throws MessagingException {
        if(body==null) body = "mail di default";
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        //SimpleMailMessage message = new SimpleMailMessage();
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true);
        // con google non si può forzare l'indirizzo email di chi invia
        helper.setFrom("your-email@gmail.com");

        mailSender.send(message);
        System.out.println("Email inviata con successo a " + to);
    }
}
