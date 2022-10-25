package com.validate_song_information.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

public class applicationConfig {
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("msg/ValidateMessage");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
