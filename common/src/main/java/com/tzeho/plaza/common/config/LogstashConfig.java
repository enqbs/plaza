package com.tzeho.plaza.common.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/* @description 检查 Logstash 插件是否运行
 * @author tzeho */
@Slf4j
@Configuration
public class LogstashConfig {

    @Value("${logstash.host}")
    private String host;
    @Value("${logstash.port}")
    private String port;

    @PostConstruct
    public void init() {
        if (StringUtils.isEmpty(host) && StringUtils.isEmpty(port)) {
            log.info("Logstash is not running...");
        } else {
            log.info("Server [{}:{}] Logstash is running now...", host, port);
        }
    }

}
