package com.smartin.tr.otojet.mailservice.MailService.Repository;

import com.smartin.tr.otojet.mailservice.MailService.Model.MailLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailLogRepository extends JpaRepository<MailLog,Long> {
}
