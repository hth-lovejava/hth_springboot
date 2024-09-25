package com.combat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class CombatApplication {

    public static void main(String[] args) {
        SpringApplication.run(CombatApplication.class, args);
    }

}
