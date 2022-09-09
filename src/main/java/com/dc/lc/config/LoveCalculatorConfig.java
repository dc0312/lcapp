package com.dc.lc.config;

import com.dc.lc.formatter.AmountFormatter;
import com.dc.lc.formatter.CardFormatter;
import com.dc.lc.formatter.PhoneFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;
import java.util.logging.Logger;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.dc.lc")
@PropertySources({
        @PropertySource("classpath:mail.properties")
})
public class LoveCalculatorConfig implements WebMvcConfigurer {

    Logger logger =  Logger.getLogger(LoveCalculatorConfig.class.getName());
    @Autowired
    private Environment env;

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

    @Bean
    public JavaMailSenderImpl getJavaMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        logger.info(">>>>>>>fetching host "+ env.getProperty("mail.host"));
        javaMailSender.setHost(env.getProperty("mail.host"));
        javaMailSender.setUsername(env.getProperty("mail.username"));
        javaMailSender.setPassword(env.getProperty("mail.password"));
        javaMailSender.setPort(getIntegerForString(env.getProperty("mail.port")));
        javaMailSender.setJavaMailProperties(getProperties());

        return javaMailSender;
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.smptp.ssl.trust","smtp.gmail.com");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        return properties;
    }

    private int getIntegerForString(String key){
        return Integer.parseInt(key);
    }


    @Override
    public Validator getValidator(){
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setValidationMessageSource(messageSource());
        return localValidatorFactoryBean;
    }
}
