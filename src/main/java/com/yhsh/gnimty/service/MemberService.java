package com.yhsh.gnimty.service;

import com.yhsh.gnimty.entity.Member;

public interface MemberService {
    Member saveMember(Member member);
    Member getMemberById(Long id);
}
