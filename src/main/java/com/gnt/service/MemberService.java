package com.gnt.service;

import com.gnt.entity.Member;

public interface MemberService {
    Member saveMember(Member member);
    Member getMemberById(Long id);
}
