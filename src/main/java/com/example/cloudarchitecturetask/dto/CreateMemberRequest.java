package com.example.cloudarchitecturetask.dto;

import lombok.Getter;

@Getter
public class CreateMemberRequest {
    private String name;
    private Long age;
    private String mbti;
}
