package mylab.notification.di.annot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.NotificationService;
import mylab.notification.di.annot.SmsNotificationService;

@Configuration
public class NotificationConfig {
	
	@Bean("email")
	public NotificationService emailService() {
		return new EmailNotificationService("smtpServer", 8080);
	}
	
	@Bean("sms")
	public NotificationService smsService() {
		return new SmsNotificationService("provider");
	}
	
	@Bean
	public NotificationManager manager() {
		NotificationManager manager = new NotificationManager(emailService(), smsService());
		return manager;
	}
}
