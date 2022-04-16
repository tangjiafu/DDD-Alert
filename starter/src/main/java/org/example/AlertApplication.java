package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @author Lager.Tang create: 2022-04-09 20:08
 **/

@SpringBootApplication(scanBasePackages = "org.example")
@MapperScan("org.example.infrastructure.db.mapper")
public class AlertApplication {

  public static void main(String[] args) {
    SpringApplication.run(AlertApplication.class, args);
  }

}
