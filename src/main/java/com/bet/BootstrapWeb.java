package com.bet;

/**
 * Created by pengweiyuan on 4/3/16.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {FreeMarkerAutoConfiguration.class})
@EnableTransactionManagement
@EnableScheduling
public class BootstrapWeb extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BootstrapWeb.class);
    }


    public static void main(String[] args) {
        System.setProperty("java.net.preferIPv4Stack", "true");
        SpringApplication app = new SpringApplication(BootstrapWeb.class);
        ApplicationContext applicationContext = app.run(args);
        System.err.println("over!!!");
    }
}
