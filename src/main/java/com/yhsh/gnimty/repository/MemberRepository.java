package com.yhsh.gnimty.repository;

import com.yhsh.gnimty.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface MemberRepository extends JpaRepository<Member, Long> {
}
