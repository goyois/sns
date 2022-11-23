package com.sns.member.controller;

import com.sns.common.dto.SingleResponseDto;
import com.sns.member.dto.RequestDto;
import com.sns.member.domain.entity.Member;
import com.sns.member.mapper.MemberMapper;
import com.sns.member.domain.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/v1/members")
@RequiredArgsConstructor
@Validated
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper mapper;

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody RequestDto.Post post) {
        Member member = memberService.createMember(mapper.postToMember(post));
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.memberToResponse(member)),HttpStatus.CREATED;
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive long memberId,
                                      @Valid @RequestBody RequestDto.Patch patch) {
        patch.setMemberId(memberId);
        Member member = memberService.updateMember(mapper.patchToMember(patch));
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.memberToResponse(member)),HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId) {
        Member member = memberService.findMember(memberId);
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.memberToResponse(member)),HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive long memberId) {
        memberService.deleteMember(memberId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}