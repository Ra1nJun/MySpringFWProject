package mylab.notification.di.annot.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.NotificationService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {
	@Autowired
	NotificationManager manager;
	
	@Resource(name = "email")
	NotificationService email;
	@Resource(name = "sms")
	NotificationService sms;
	
	@Test
	void testNotificationConfig() {
		assertNotNull(manager.getEmailService());
		assertNotNull(manager.getSmsService());
		manager.sendNotificationByEmail("!!!Email-Message!!!");
		manager.sendNotificationBySms("!!!SMS-Message!!!");
	}
}