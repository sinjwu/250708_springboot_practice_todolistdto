package com.practice._250708_springboot_practice_todolistdto.controller;

import com.practice._250708_springboot_practice_todolistdto.dto.SignupDTO;
import com.practice._250708_springboot_practice_todolistdto.model.User;
import com.practice._250708_springboot_practice_todolistdto.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SignupController {
    private final UserRepository userRepository;

    @GetMapping("/signup")
    public String showSignup(Model model) {
        model.addAttribute("signupDto", new SignupDTO());
        return "signup";
    }
    @PostMapping("/signup")
    public String doSignup(
            @Valid @ModelAttribute SignupDTO signupDTO,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        if (userRepository.findByUsername(signupDTO.getUsername()) != null) {
            model.addAttribute("error", "이미 사용 중인 ID입니다.");
        }
        //중복 가입 여부 체크
        User user = User.builder().username(signupDTO.getUsername()).password(signupDTO.getPassword()).build();
        userRepository.save(user);
        return "redirect:/login?registered";
    }
}
