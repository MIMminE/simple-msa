package my.project.msa.userservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-service")
@Slf4j
public class hello {

    @GetMapping("/hello")
    public String test(){
        return "hello";
    }
}