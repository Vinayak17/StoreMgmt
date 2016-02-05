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
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//As Equivalent to applicationContext.xml

@Configuration
@EnableWebMvc
@ComponentScan("com.storemgmt") 
/*First, the @Controller annotation indicates that this class is a controller class. This annotation
is a specialization of the @Component annotation, which means that <context:
component-scan> will pick up and register @Controller-annotated classes as beans,
just as if they were annotated with @Component.
That means that we need to configure a <context:component-scan> in spitter-
servlet.xml so that the HomeController class (and all of the other controllers we’ll
write) will be automatically discovered and registered as beans. Here’s the relevant
snippet of XML:
<context:component-scanbase-package="com.habuma.spitter.mvc"/>*/
public class SpringConfig extends WebMvcConfigurerAdapter{

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
    
    //this function is alternate for <mvc:resources mapping="/resources/**" location="/resources/" />
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("resources/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("resources/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("resources/js/").setCachePeriod(31556926);
    }
}
