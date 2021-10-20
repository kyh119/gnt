package com.gnt.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class RefreshController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PatchMapping(value = "/search")
    public String update(@RequestParam(value = "userName") String userName) {

        try {
            StringBuilder sb = new StringBuilder(userName);
            if (userName.length() == 2)
                userName = sb.insert(1, " ").toString();
            userName = URLEncoder.encode(userName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.warn("인코딩 오류");
        }
        return "redirect:/search/" + userName;
    }
}
