package carServiceSystem.services.auth;

import carServiceSystem.dto.SignupDTO;
import carServiceSystem.dto.UserDTO;
import carServiceSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface AuthService {

    UserDTO createUser(SignupDTO signupDTO);
}
