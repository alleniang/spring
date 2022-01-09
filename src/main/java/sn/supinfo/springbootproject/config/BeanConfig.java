package sn.supinfo.springbootproject.config;

import org.springframework.context.annotation.Bean;

import nz.net.ultraq.thymeleaf.LayoutDialect;
public class BeanConfig {
   
	@Bean
	public LayoutDialect layoutDialect() {
		// TemplateEngine engine = new TemplateEngine();
		return new LayoutDialect();
	} 
}
