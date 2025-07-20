package com.example.LibraryManagementSystem.service.Imp;

import com.example.LibraryManagementSystem.Repositry.MemberRepository;
import com.example.LibraryManagementSystem.dto.MemberDto;
import com.example.LibraryManagementSystem.entity.Member;
import com.example.LibraryManagementSystem.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl {

    @Autowired
    private  MemberRepository memberRepository;
    @Autowired
    private  MemberMapper memberMapper;



    public List<MemberDto> getAllMembers() {
        return memberRepository.findAll().stream()
                .map(memberMapper::toDto)
                .collect(Collectors.toList());
    }

    public MemberDto getMemberById(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        return memberMapper.toDto(member);
    }

    public MemberDto createMember(MemberDto dto) {
        Member member = memberMapper.toEntity(dto);
        member.setRegistrationDate(LocalDate.now());
        return memberMapper.toDto(memberRepository.save(member));
    }

    public MemberDto updateMember(Long id, MemberDto dto) {
        Member existing = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());
        existing.setPhone(dto.getPhone());
        existing.setAddress(dto.getAddress());

        return memberMapper.toDto(memberRepository.save(existing));
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}

