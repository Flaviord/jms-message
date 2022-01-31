package com.jms.example.demo;

import com.jms.example.demo.model.PersonMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class JmsApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JmsApplication.class, args);

		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

		jmsTemplate.send("msg.message", send -> send.createTextMessage("#1 >>>>Simple String message<<<<"));
		jmsTemplate.convertAndSend("msg.message.converter", new PersonMessage(1, ">>>Hey! The newest simple message by converter!"));
	}
}
