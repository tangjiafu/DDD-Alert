package org.example

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 *
 *
 * @author Lager.Tang
 *         create: 2022-04-09 19:41
 * */
@SpringBootApplication(scanBasePackages = Array("com.example"))
@MapperScan(Array("org.example.infrastructure.db.mapper"))
class AppApplication

object AppStarter extends App {
  SpringApplication.run(classOf[AppApplication])
}
