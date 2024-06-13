package org.springwatt.springwatt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloDuodome {

    @Value("${hello.message}")
    private String message;

    @GetMapping("/hello-duodome")
    public String hello() {
        return message;
    }
}
