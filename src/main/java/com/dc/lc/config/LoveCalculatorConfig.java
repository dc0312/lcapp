package com.dc.lc.config;

import com.dc.lc.formatter.AmountFormatter;
import com.dc.lc.formatter.CardFormatter;
import com.dc.lc.formatter.PhoneFormatter;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.dc.lc")
public class LoveCalculatorConfig implements WebMvcConfigurer {


    //Create view resolver
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/view/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }


    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new PhoneFormatter());
        registry.addFormatter(new CardFormatter());
        registry.addFormatter(new AmountFormatter());
    }

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("message");
        return messageSource;
    }


    @Override
    public Validator getValidator(){
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setValidationMessageSource(messageSource());
        return localValidatorFactoryBean;
    }
}
