package com.prysnail.simulation.login;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.prysnail.simulation.login.infra.mapper")
public class SimulationLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimulationLoginApplication.class, args);
    }

}
