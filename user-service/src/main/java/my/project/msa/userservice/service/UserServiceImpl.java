package my.project.msa.userservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.project.msa.userservice.dto.UserDto;
import my.project.msa.userservice.entity.UserEntity;
import my.project.msa.userservice.mapper.UserServiceMapper;
import my.project.msa.userservice.repository.UserRepository;
import my.project.msa.userservice.vo.response.ResponseOrder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private UserServiceMapper mapper = UserServiceMapper.INSTANCE;

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());
        UserEntity userEntity = mapper.ToUserEntity(userDto, "Encrypted Password");
        userRepository.save(userEntity);
        return userDto;
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);

        if (userEntity == null) return null;

        // TODO
        List<ResponseOrder> orders = new ArrayList<>();

        return mapper.toUserDto(userEntity, orders);
    }

    @Override
    public Iterable<UserEntity> getUserByAll() {
        return userRepository.findAll();
    }
}
