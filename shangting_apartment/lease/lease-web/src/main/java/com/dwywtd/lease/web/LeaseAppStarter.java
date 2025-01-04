package com.dwywtd.lease.web;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.dwywtd.lease"})
@MapperScan("com.dwywtd.lease.**.mapper")
public class LeaseAppStarter {

    public static void main(String[] args) {
        SpringApplication.run(LeaseAppStarter.class, args);
    }

}
