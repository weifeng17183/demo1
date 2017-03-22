package com.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = { "classpath:spring-mybatis.xml" })
@ComponentScan(basePackages = { "com.demo.core.service.impl" })
public class CoreConfig {

}
