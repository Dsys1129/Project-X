package io.duodome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {

    @RequestMapping(value = "/springwatt/hello-duodome", method = RequestMethod.GET)
    @ResponseBody
    public String helloWorld() {
        return "Hello, DuoDome";
    }

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "Hello";
    }

    @PostMapping("/springwatt/advanced-greeting")
    @ResponseBody
    public String helloSpring() {
        return "Hello, Spring!";
    }
}
