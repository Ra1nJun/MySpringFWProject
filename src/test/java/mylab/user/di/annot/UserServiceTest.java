package mylab.user.di.annot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {
	@Autowired
	UserService userSerice;
	
	
	@Test
	void testUserService() {
		assertNotNull(userSerice);
		assertNotNull(userSerice.getUserRepository());
		assertEquals("MySQL", userSerice.getUserRepository().getDbType());
		assertNotNull(userSerice.getSecurityService());
		System.out.println(userSerice.registerUser("userId", "name", "password"));
	
	}
	
}
