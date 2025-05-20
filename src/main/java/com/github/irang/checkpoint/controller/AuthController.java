package com.github.irang.checkpoint.controller;

import com.github.irang.checkpoint.dto.UserDto;
import com.github.irang.checkpoint.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final UserService userService;  // 사용자 생성, 회원가입 처리 서비스

    public AuthController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        return "login";  // src/main/resources/templates/login.html
    }

    @GetMapping("/signup")
    public String signupForm(Model model){
        model.addAttribute("user", new UserDto());  // DTO 활용 추천
        return "signup";
    }

    @PostMapping("/signup")
    public String signupSubmit(@ModelAttribute UserDto userDto){
        userService.registerUser(userDto);
        return "redirect:/login";
    }
}
