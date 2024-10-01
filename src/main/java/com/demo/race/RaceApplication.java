package com.demo.race;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Emmanuel-Irabor
 * @since 01/09/2024
 */

@SpringBootApplication(
        scanBasePackages = {
                "com.clickatell.race"
        }
)
public class RaceApplication {
        public static void main(String[] args) {
                SpringApplication.run(RaceApplication.class,args);
                System.out.println("RaceApplication Start success!");
        }
}
