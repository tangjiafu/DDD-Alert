package org.example.config;

import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

/**
 * @author Lager.Tang
 * create: 2022-06-15 14:07
 **/
@Slf4j
public class PropConfig implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

  @Override
  public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
    ConfigurableEnvironment environment = event.getEnvironment();

    String oldValue = environment.getProperty("spring.datasource.password");
    System.out.println("old value:" + oldValue);
    String newValue = "123456";
    Properties props = new Properties();
    props.put("spring.datasource.password", newValue);
    environment.getPropertySources().addFirst(new PropertiesPropertySource("decrypted_properties", props));

  }
}
