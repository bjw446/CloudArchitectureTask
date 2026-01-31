package com.example.cloudarchitecturetask.controller;

import com.example.cloudarchitecturetask.dto.CreateMemberRequest;
import com.example.cloudarchitecturetask.dto.CreateMemberResponse;
import com.example.cloudarchitecturetask.dto.GetMemberResponse;
import com.example.cloudarchitecturetask.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/api/members")
    public ResponseEntity<CreateMemberResponse> createMember (@RequestBody CreateMemberRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.createMember(request));
    }

    @GetMapping("/api/members/{id}")
    public ResponseEntity<GetMemberResponse> getOneMember (@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.getOneMember(id));
    }

}
