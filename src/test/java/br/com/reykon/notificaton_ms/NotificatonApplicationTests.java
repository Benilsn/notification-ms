package br.com.reykon.notificaton_ms;

import br.com.reykon.notification_ms.NotificatonMsApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest(classes = NotificatonMsApplication.class)
class NotificatonApplicationTests {

	@Test
	@DisplayName("Test - NotificatonApplication")
	void contextLoads() {}

}
