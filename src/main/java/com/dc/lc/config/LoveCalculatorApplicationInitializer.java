package com.dc.lc.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class LoveCalculatorApplicationInitializer  //implements WebApplicationInitializer
{
    //@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
       //1. Create webapplication context
//        XmlWebApplicationContext xmlWebApplicationContext = new XmlWebApplicationContext();
//        xmlWebApplicationContext.setConfigLocation("classpath:application-config.xml");
        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
        annotationConfigWebApplicationContext.register(LoveCalculatorConfig.class);
        //2. create DispatcherServlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(annotationConfigWebApplicationContext);
        //3. Register servlet context
        ServletRegistration.Dynamic myCustomDispatcherServlet = servletContext.addServlet("myDispatcherServlet",dispatcherServlet);

        //4. Setup URL mapping and load-on-startup
        myCustomDispatcherServlet.setLoadOnStartup(1);
        myCustomDispatcherServlet.addMapping("/mywebsite.com/*");


    }
}
