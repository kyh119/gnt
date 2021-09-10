package com.yhsh.gnimty.controller;

import com.yhsh.gnimty.entity.Member;
import com.yhsh.gnimty.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MemberController {
    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/join")
    public String createMemberForm(Model model) {
        Member member = new Member();
        model.addAttribute("member", member);
        return "join";
    }

    @PostMapping("/join")
    public String saveMember(@ModelAttribute Member member, HttpServletRequest request) {
        memberService.saveMember(member);
        request.getSession().setAttribute("user", member);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        return "login";
    }

}
