package my.project.msa.userservice.controller;

import lombok.extern.slf4j.Slf4j;
import my.project.msa.userservice.vo.RequestUser;
import my.project.msa.userservice.vo.messages.Greeting;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-service")
@Slf4j
public class UserServiceController {

//    private Environment env;

//    public UserServiceController(Environment env) {
//        this.env = env;
//    }

    private Greeting greeting;

    public UserServiceController(Greeting greeting) {
        this.greeting = greeting;
    }

    @GetMapping("/hello")
    public String test(){
        return "hello";
    }

    @GetMapping("/health_check")
    public String status(){
        return "It's Working in User Service";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return greeting.getMessage();
//        return env.getProperty("greeting.message");
    }

    @PostMapping("/users")
    public String createUser(@RequestBody RequestUser user){
        return "Create user method is called";
    }
}
