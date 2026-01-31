package com.example.cloudarchitecturetask.repository;

import com.example.cloudarchitecturetask.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
