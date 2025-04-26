package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class) //AplicationContext (컨테이너) 객체를 생성하는 역할
@ContextConfiguration(locations = "classpath:hello-di.xml")
public class HelloSpringTest {
	@Autowired
	Hello hello; //getBean
	
	@Autowired
	Printer strPrinter;
	
	@Autowired
	@Qualifier("strPrinter")
	Printer printer;
	
	@Resource(name = "hello")
	Hello helloBean;
	
	@Test
	void HelloSpringBean() {
		assertEquals("Hello 스프링", hello.sayHello());
		hello.print();
		assertEquals("Hello 스프링", strPrinter.toString());
		
		System.out.println(strPrinter.getClass().getName());
		
		assertEquals("Hello 스프링", printer.toString());
		
		assertEquals("Hello 스프링", helloBean.sayHello());
	}
}
