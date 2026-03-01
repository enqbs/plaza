package com.tzeho.plaza.common.config;

import lombok.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/* @description 数据强制返回 JSON 格式
 * @author tzeho */
@Configuration
public class JsonResponseConfig implements WebMvcConfigurer {

    @Override
    public void configureContentNegotiation(@NonNull ContentNegotiationConfigurer configurer) {
        configurer
                .ignoreAcceptHeader(true)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType(MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON);
    }

}
