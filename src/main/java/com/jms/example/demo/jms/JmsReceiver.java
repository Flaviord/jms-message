package com.jms.example.demo.jms;

import com.jms.example.demo.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Slf4j
@Component
public class JmsReceiver {

    @JmsListener(destination = "msg.message")
    public void receiveMessage(TextMessage msg) throws JMSException {
        log.info(String.format("Message passed: %s", msg.getText()));
    }

    @JmsListener(destination = "msg.message.converter", containerFactory = "myJmsFactory")
    public void receiveMessage(Message message) {
        log.info(String.format("MESSAGE PASSED: %s", message));
    }
}
