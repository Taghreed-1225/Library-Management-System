package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.dto.MemberDto;
import com.example.LibraryManagementSystem.entity.Member;
import com.example.LibraryManagementSystem.service.Imp.MemberServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberServiceImpl memberService;

    public MemberController(MemberServiceImpl memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<MemberDto> getAll() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public MemberDto getById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    @PostMapping
    public MemberDto create(@RequestBody MemberDto memberDto) {
        return memberService.createMember(memberDto);
    }

    @PutMapping("/{id}")
    public MemberDto update(@PathVariable Long id, @RequestBody MemberDto memberDto) {
        return memberService.updateMember(id, memberDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        memberService.deleteMember(id);
    }
}
