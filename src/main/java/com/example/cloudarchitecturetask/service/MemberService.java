package com.example.cloudarchitecturetask.service;

import com.example.cloudarchitecturetask.dto.CreateMemberRequest;
import com.example.cloudarchitecturetask.dto.CreateMemberResponse;
import com.example.cloudarchitecturetask.dto.GetMemberResponse;
import com.example.cloudarchitecturetask.entity.Member;
import com.example.cloudarchitecturetask.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public CreateMemberResponse createMember(CreateMemberRequest request) {
        Member member = new Member(
                request.getName(),
                request.getAge(),
                request.getMbti()
        );
        Member savedMember = memberRepository.save(member);
        return new CreateMemberResponse(
                savedMember.getId(),
                savedMember.getName(),
                savedMember.getAge(),
                savedMember.getMbti()
        );
    }

    @Transactional(readOnly = true)
    public GetMemberResponse getOneMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("없는 멤버 입니다.")
        );
        return new GetMemberResponse(
                member.getId(),
                member.getName(),
                member.getAge(),
                member.getMbti()
        );
    }
}
