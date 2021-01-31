package com.ibm.learning.emailer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;

/* This class will be used to configure the beans of 
 * DummyEmailSender.java and SmtpEmailSender.java
 * as we may not have source code of these classes
 * but we want to use them as Spring Bean*/

@Configuration
public class MailConfig {
	
	@Bean
	@Profile("dev")
	public EmailService dummyEmailSender() {
		return new DummyEmailSender();
	}
	
	@Bean
	@Profile("zomato")
	
	public EmailService smtpEmailSender(JavaMailSender javaMailSender) {
		return new SmtpEmailSender(javaMailSender);
	}
}
