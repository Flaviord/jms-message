package com.jms.example.demo.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;

@Component
@EnableJms
public class JMSConfig {
    private final JmsErrorHandler jmsErrorHandler;

    @Autowired
    public JMSConfig(JmsErrorHandler jmsErrorHandler) {
        this.jmsErrorHandler = jmsErrorHandler;
    }

    @Bean
    public JmsListenerContainerFactory<?> myJmsFactory(ConnectionFactory connectionFactory,
                                                       DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setErrorHandler(jmsErrorHandler);

        configurer.configure(factory, connectionFactory);
        return factory;
    }

    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}
