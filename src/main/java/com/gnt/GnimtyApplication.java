package com.gnt;

import com.gnt.repository.MemberRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GnimtyApplication {

    public static void main(String[] args) {
        SpringApplication.run(GnimtyApplication.class, args);
    }

    private MemberRepository memberRepository;

}
