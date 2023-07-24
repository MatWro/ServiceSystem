package carServiceSystem.services;

import carServiceSystem.dto.UserDto;
import carServiceSystem.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
