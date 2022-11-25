package com.iviettech.thuanpv;

import com.iviettech.thuanpv.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    public static void main(String[] args) {
        ApplicationContext context  = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println("ok");
    }
}
