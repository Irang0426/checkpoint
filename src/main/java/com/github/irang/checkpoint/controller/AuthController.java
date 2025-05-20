package com.github.irang.checkpoint.controller;

import com.github.irang.checkpoint.dto.UserDto;
import com.github.irang.checkpoint.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private final UserService userService;
    public AuthController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/signup")
    public String signupForm(Model model){
        model.addAttribute("user", new UserDto());  // DTO 활용 추천
        return "signup";
    }

    @PostMapping("/signup")
    public String signupSubmit(@ModelAttribute("user") UserDto userDto, Model model, RedirectAttributes redirectAttributes){
        try {
            userService.registerUser(userDto);
            redirectAttributes.addFlashAttribute("successMessage", "회원가입에 성공했습니다!");
            return "redirect:/login";  // 회원가입 성공하면 로그인 페이지로
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/signup";  // 회원가입 폼 페이지에 에러 메시지 보여주기
        }
    }
}
