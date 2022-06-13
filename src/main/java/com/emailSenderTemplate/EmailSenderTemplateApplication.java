package com.emailSenderTemplate;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.emailSenderTemplate.model.Email;
import com.emailSenderTemplate.service.EmailService;

@SpringBootApplication
public class EmailSenderTemplateApplication implements ApplicationRunner {

	private static Logger log = LoggerFactory.getLogger(EmailSenderTemplateApplication.class);

    @Autowired
    private EmailService emailService;
	
	public static void main(String[] args) {
		SpringApplication.run(EmailSenderTemplateApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("Sending Email with Thymeleaf HTML Template Example");

        Email mail = new Email();
        mail.setFrom("mansi.malik@oodles.io");
        mail.setTo("mansi.malik@oodles.io");
        mail.setSubject("Sending Email with Thymeleaf HTML Template Example");

        Map model = new HashMap();
        model.put("name", "Mansi Malik");
        model.put("location", "Gurgaon");
       // model.put("signature", "https://memorynotfound.com");
        mail.setModel(model);

        emailService.sendSimpleMessage(mail);
		
	}

}
