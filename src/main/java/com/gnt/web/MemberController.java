package com.gnt.web;

import com.gnt.domain.user.User;
import com.gnt.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final UserService userService;

    @GetMapping("/join")
    public String createMemberForm(Model model) {
        User user = new User();
        model.addAttribute("member", user);
        return "join";
    }

    @PostMapping("/join")
    public String saveMember(@ModelAttribute User user, HttpServletRequest request) {
        userService.saveUser(user);
        request.getSession().setAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        return "login";
    }

}
