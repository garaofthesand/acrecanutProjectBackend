package com.tridentSoft.arecanut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "com.tridentSoft.arecanut",
        "com.tridentSoft.devtools"
})
@EnableJpaRepositories(basePackages = {
        "com.tridentSoft.devtools.repository",
        "com.tridentSoft.arecanut.repository"
})
@EntityScan(basePackages = {
        "com.tridentSoft.devtools.domain",
        "com.tridentSoft.arecanut.domain"
})
public class ArecanutApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArecanutApplication.class, args);
    }
}
