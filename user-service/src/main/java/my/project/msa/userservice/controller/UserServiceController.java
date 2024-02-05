package my.project.msa.userservice.controller;

import lombok.extern.slf4j.Slf4j;
import my.project.msa.userservice.dto.UserDto;
import my.project.msa.userservice.entity.UserEntity;
import my.project.msa.userservice.mapper.UserServiceMapper;
import my.project.msa.userservice.service.UserService;
import my.project.msa.userservice.vo.RequestUser;
import my.project.msa.userservice.vo.messages.Greeting;
import my.project.msa.userservice.vo.response.ResponseObject;
import my.project.msa.userservice.vo.response.ResponseUser;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user-service")
@Slf4j
public class UserServiceController {

    private Environment env;
    private Greeting greeting;
    private UserService userService;
    private UserServiceMapper mapper = UserServiceMapper.INSTANCE;

    public UserServiceController(Greeting greeting, UserService userService, Environment env)
    {
        this.userService = userService;
        this.greeting = greeting;
        this.env = env;
    }

    @GetMapping("/health_check")
    public String status() {
        return String.format("It's Working in User Service on PORT %s",
                env.getProperty("local.server.port"));
    }

    @GetMapping("/welcome")
    public String welcome() {
        return greeting.getMessage();
//        return env.getProperty("greeting.message");
    }

    @GetMapping("/users")
    public ResponseEntity<ResponseObject>getUsers(){
        Iterable<UserEntity> userByAll = userService.getUserByAll();

        List<ResponseUser> responseUsers = new ArrayList<>();
        userByAll.forEach(e ->
                responseUsers.add(mapper.toResponseUser(userService.getUserByUserId(e.getUserId())))
        );
        ResponseObject response = new ResponseObject(responseUsers, responseUsers.size());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseObject> getUser(@PathVariable String userId){
        UserDto userDto = userService.getUserByUserId(userId);

        ResponseObject response = new ResponseObject(mapper.toResponseUser(userDto), 1);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/users")
    public ResponseEntity<ResponseObject> createUser(@RequestBody RequestUser requestUser) {
        UserDto userDto = userService.createUser(mapper.toUserDto(requestUser));
        ResponseObject response = new ResponseObject(mapper.toResponseUser(userDto), 1);
        String locationUri = String.format("/users/%s", userDto.getUserId());
        response.setFields("URI", locationUri);
        return ResponseEntity.created(URI.create(locationUri)).body(response);
    }
}
