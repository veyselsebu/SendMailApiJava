package com.smartin.tr.otojet.mailservice.MailService.Controller;

import com.smartin.tr.otojet.mailservice.MailService.Model.MailLog;
import com.smartin.tr.otojet.mailservice.MailService.Service.MailService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailResource {
  private final MailService mailService;

    public MailResource(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("")
    public Object mailSend (@RequestBody MailLog mail){
        return mailService.aMailSend(mail);
    }


}
