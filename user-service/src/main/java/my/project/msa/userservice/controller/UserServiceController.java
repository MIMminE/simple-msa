package my.project.msa.userservice.controller;

import lombok.extern.slf4j.Slf4j;
import my.project.msa.userservice.dto.UserDto;
import my.project.msa.userservice.service.UserService;
import my.project.msa.userservice.vo.RequestUser;
import my.project.msa.userservice.vo.ResponseUser;
import my.project.msa.userservice.vo.messages.Greeting;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/user-service")
@Slf4j
public class UserServiceController {

//    private Environment env;

//    public UserServiceController(Environment env) {
//        this.env = env;
//    }


    private Greeting greeting;
    private UserService userService;

    public UserServiceController(Greeting greeting, UserService userService)
    {
        this.userService = userService;
        this.greeting = greeting;
    }

    @GetMapping("/health_check")
    public String status() {
        return "It's Working in User Service";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return greeting.getMessage();
//        return env.getProperty("greeting.message");
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = mapper.map(user, UserDto.class);
        userService.createUser(userDto);

        ResponseUser responseUser = mapper.map(userDto, ResponseUser.class);
        return ResponseEntity.created(URI.create("uri")).body(responseUser);
    }
}
