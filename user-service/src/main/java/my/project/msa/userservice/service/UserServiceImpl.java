package my.project.msa.userservice.service;

import my.project.msa.userservice.dto.UserDto;

import java.util.UUID;

public class UserServiceImpl implements UserService{

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());

        return null;
    }
}
