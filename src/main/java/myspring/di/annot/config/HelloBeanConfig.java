package myspring.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages= {"myspring.di.annot"})
@PropertySource(value = "classpath:values.properties")
public class HelloBeanConfig {
	public HelloBeanConfig() {
		System.out.println(this.getClass().getName()+"Config class 기본생성자 호출됨!");
	}

}
