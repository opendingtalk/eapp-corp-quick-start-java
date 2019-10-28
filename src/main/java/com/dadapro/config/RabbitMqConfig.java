package com.dadapro.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @date 2019-10-21
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue dingErpMessage() {
        return new Queue("ding_erp_message");
    }

}
