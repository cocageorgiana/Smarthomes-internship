package com.example.smarthomes.soapservice.web_config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    /**
     * Created a configuration bean that creates an endpoint for resources
     * @param applicationContext The current application context for which we create this bean
     * @return A new Servlet containing the endpoint for resources
     */

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    /**
     * Created a configuration bean that creates the endpoint at which requests will be made
     * @param articlesSchema The XSDSchema which contains the behaviour of the requests defined in the XML File
     * @return The actual definition of the schema
     */

    @Bean(name = "articles")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema articlesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ArticlesPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
        wsdl11Definition.setSchema(articlesSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema articlesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("articles.xsd"));
    }
}
