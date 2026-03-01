package com.tzeho.plaza.common.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/* @description 检查 Logstash 插件是否运行
 * @author tzeho */
@Slf4j
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "logstash")
public class LogstashConfig {

    private String host;
    private String port;

    @PostConstruct
    public void init() {
        if (host.isBlank() && port.isBlank()) {
            log.info("Logstash is not running...");
        } else {
            log.info("Server [{}:{}] Logstash is running now...", host, port);
        }
    }

}
