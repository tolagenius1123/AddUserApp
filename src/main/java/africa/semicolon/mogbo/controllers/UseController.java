package africa.semicolon.mogbo.controllers;

import africa.semicolon.mogbo.dto.requests.LoginUserRequest;
import africa.semicolon.mogbo.dto.requests.RegisterUserRequest;
import africa.semicolon.mogbo.dto.responses.LoginUserResponse;
import africa.semicolon.mogbo.dto.responses.RegisterUserResponse;
import africa.semicolon.mogbo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UseController {

    @Autowired
    private UserService userService;


    @PostMapping("/user")
    public RegisterUserResponse register (@RequestBody RegisterUserRequest request){
        return userService.registerUser(request);

    }

    @PostMapping("/login/user")
    public LoginUserResponse login(@RequestBody LoginUserRequest request){
        return userService.login(request);
    }


}
