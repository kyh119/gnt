package com.gnt.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @GetMapping("/search")
    public String search(@RequestParam(value = "userName") String userName) {
        return "redirect:/search/" + userName;
    }

    @GetMapping("/search/{userName}")
    public String searchByName(@PathVariable String userName) {
        return "summoner";
    }

}
