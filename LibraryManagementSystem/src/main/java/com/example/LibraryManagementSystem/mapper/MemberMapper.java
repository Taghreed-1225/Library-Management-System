package com.example.LibraryManagementSystem.mapper;

import com.example.LibraryManagementSystem.dto.MemberDto;
import com.example.LibraryManagementSystem.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public MemberDto toDto(Member member) {
        return new MemberDto(
                member.getId(),
                member.getName(),
                member.getEmail(),
                member.getPhone(),
                member.getAddress()
        );
    }

    public Member toEntity(MemberDto dto) {
        Member member = new Member();
        member.setId(dto.getId());
        member.setName(dto.getName());
        member.setEmail(dto.getEmail());
        member.setPhone(dto.getPhone());
        member.setAddress(dto.getAddress());
        return member;
    }
}

