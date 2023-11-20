package com.juanodsk.ecommerce.controller;


import com.juanodsk.ecommerce.dto.ResponseDto;
import com.juanodsk.ecommerce.model.User;
import com.juanodsk.ecommerce.service.AuthenticationService;
import com.juanodsk.ecommerce.service.UserService;
import com.juanodsk.ecommerce.dto.*;
import com.juanodsk.ecommerce.dto.user.SignInDto;
import com.juanodsk.ecommerce.dto.user.SignInResponseDto;
import com.juanodsk.ecommerce.dto.user.SignupDto;
import com.juanodsk.ecommerce.exceptions.AuthenticationFailException;
import com.juanodsk.ecommerce.exceptions.CustomException;
import com.juanodsk.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> findAllUser(@RequestParam("token") String token) throws AuthenticationFailException {
        authenticationService.authenticate(token);
        return userRepository.findAll();
    }

    @PostMapping("/signup")
    public ResponseDto Signup(@RequestBody SignupDto signupDto) throws CustomException {
        return userService.signUp(signupDto);
    }

    //TODO token should be updated
    @PostMapping("/signIn")
    public SignInResponseDto Signup(@RequestBody SignInDto signInDto) throws CustomException {
        return userService.signIn(signInDto);
    }

//    @PostMapping("/updateUser")
//    public ResponseDto updateUser(@RequestParam("token") String token, @RequestBody UserUpdateDto userUpdateDto) {
//        authenticationService.authenticate(token);
//        return userService.updateUser(token, userUpdateDto);
//    }


//    @PostMapping("/createUser")
//    public ResponseDto updateUser(@RequestParam("token") String token, @RequestBody UserCreateDto userCreateDto)
//            throws CustomException, AuthenticationFailException {
//        authenticationService.authenticate(token);
//        return userService.createUser(token, userCreateDto);
//    }
}
