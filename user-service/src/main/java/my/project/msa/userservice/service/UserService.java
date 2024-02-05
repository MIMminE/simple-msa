package my.project.msa.userservice.service;

import my.project.msa.userservice.dto.UserDto;
import my.project.msa.userservice.entity.UserEntity;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUserByAll();
}
