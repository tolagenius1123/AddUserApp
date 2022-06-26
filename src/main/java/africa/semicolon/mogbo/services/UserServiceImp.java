package africa.semicolon.mogbo.services;

import africa.semicolon.mogbo.data.models.User;
import africa.semicolon.mogbo.data.repositories.UserRepository;
import africa.semicolon.mogbo.dto.requests.LoginUserRequest;
import africa.semicolon.mogbo.dto.requests.RegisterUserRequest;
import africa.semicolon.mogbo.dto.responses.LoginUserResponse;
import africa.semicolon.mogbo.dto.responses.RegisterUserResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@Slf4j

public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());

        User savedUser = userRepository.save(user);
        RegisterUserResponse response = new RegisterUserResponse();
        response.setEmail(savedUser.getEmail());
        response.setDataCreated(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy, hh:mm, a").format(savedUser.getDateTime()));
        return response;
    }

    @Override
    public LoginUserResponse login(LoginUserRequest request) {
       Optional<User> user = userRepository.findByEmail(request.getEmail());
        if (user.isPresent()){
            if(user.get().getPassword().equals(request.getPassword())){
                LoginUserResponse response = new LoginUserResponse();
                response.setMessage("Welcome back you whim!"+ user.get().getFirstName());
                return response;
            }
//            else {
//                LoginUserResponse response = new LoginUserResponse();
//                response.setMessage("Invalid Password, Please input correct password");
//            }

        }

        return null;
    }


}
