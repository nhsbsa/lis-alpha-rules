package net.nhs.nhsbsa.lis.rules.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"net.nhs.nhsbsa.lis"})
public class LisRulesWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LisRulesWebApplication.class, args);
    }

}
