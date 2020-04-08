package com.ouhamza.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.ouhamza.demo")
@EnableAspectJAutoProxy
public class DemoConfig {

}
