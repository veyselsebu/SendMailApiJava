package com.smartin.tr.otojet.mailservice.MailService.Service;

import com.smartin.tr.otojet.mailservice.MailService.Model.MailLog;
import com.smartin.tr.otojet.mailservice.MailService.Repository.MailLogRepository;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class MailService {
    private final MailLogRepository mailLogRepository;
    private final JavaMailSender javaMailSender;
    public MailService(MailLogRepository mailLogRepository, JavaMailSender javaMailSender) {
        this.mailLogRepository = mailLogRepository;
        this.javaMailSender = javaMailSender;
    }

    public Object aMailSend (MailLog mail)  {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(mail.getFromMail());
            mimeMessageHelper.setTo(mail.getToMail());
            mimeMessageHelper.setText(mail.getMailDescription());
            mimeMessageHelper.setCc(mail.getCc());
            mimeMessageHelper.setSubject(mail.getTitle());
            javaMailSender.send(mimeMessage);
            MailLog save = mailLogRepository.save(mail);
            return true;


        }catch (Exception ex){
            System.out.println("hata = " +ex.getMessage().toString());
            return "hata "+ex.getMessage();
        }
        }
}
