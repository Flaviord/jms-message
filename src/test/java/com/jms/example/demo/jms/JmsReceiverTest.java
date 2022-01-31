package com.jms.example.demo.jms;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class JmsReceiverTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {}

    @Test
    public void send_simple_string_message() {

    }

    @Test
    public void send_converter_object_message() {

    }
}