package com.storemgmt.config;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//As Equivalent to applicationContext.xml

@Configuration
//@EnableWebMvc
@ComponentScan("com.storemgmt")
public class SpringConfig {

	@Bean
	public ViewResolver getViewResolver(){

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
		
	}
	
 
    /*
     * Configure MessageSource to provide internationalized messages
     *
     */
 
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
	
    @Bean
    public ValidatorFactory getValidatorFactory(){
    	
    	return Validation.buildDefaultValidatorFactory();
    }
}
