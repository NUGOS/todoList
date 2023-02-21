package ua.goit.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test {
    @GetMapping("/test")
    void test(){
        System.out.println("Hello test controller");
    }
}
