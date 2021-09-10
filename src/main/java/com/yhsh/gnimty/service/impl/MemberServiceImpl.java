package com.yhsh.gnimty.service.impl;

import com.yhsh.gnimty.entity.Member;
import com.yhsh.gnimty.repository.MemberRepository;
import com.yhsh.gnimty.service.MemberService;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member getMemberById(Long id) {
        return memberRepository.findById(id).get();
    }
}
