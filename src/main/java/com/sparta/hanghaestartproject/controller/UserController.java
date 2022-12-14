package com.sparta.hanghaestartproject.controller;

import com.sparta.hanghaestartproject.dto.*;
import com.sparta.hanghaestartproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping ("/api/user")
@RequiredArgsConstructor
public class UserController {
     
     private final UserService userService;
     
     @PostMapping ("/signup")
     public CompleteResponseDto signup(@RequestBody @Valid SignupRequestDto signupRequestDto) {
          return userService.signup(signupRequestDto);
     }
     
     @ResponseBody
     @PostMapping("/login")
     public CompleteResponseDto login(@RequestBody @Valid LoginRequestDto loginRequestDto, HttpServletResponse response) {
          return userService.login(loginRequestDto, response);
     }
}
