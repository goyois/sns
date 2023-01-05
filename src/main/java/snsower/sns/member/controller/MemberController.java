package snsower.sns.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import snsower.sns.common.dto.MultiResponseDto;
import snsower.sns.common.dto.SingleResponseDto;
import snsower.sns.member.domain.entity.Member;
import snsower.sns.member.domain.service.MemberService;
import snsower.sns.member.dto.RequestDto;
import snsower.sns.member.mapper.MemberMapper;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

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
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.memberToResponse(member)), HttpStatus.CREATED);
    }


    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id")@Positive long memberId,
                                      @Valid @RequestBody RequestDto.Patch patch){
        patch.setMemberId(memberId);
        Member member = memberService.updateMember(mapper.patchToMember(patch));
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.memberToResponse(member)),HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId) {
        Member member = memberService.findMember(memberId);
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.memberToResponse(member)),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers(@Positive @RequestParam int page,
                                     @Positive @RequestParam int size) {
        Page<Member> pageMembers = memberService.findMembers(page - 1, size);
        List<Member> members = pageMembers.getContent();
        return new ResponseEntity<>(new MultiResponseDto<>(mapper.MembersToResponse(members),pageMembers),HttpStatus.OK);
    }


    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive long memberId) {
        memberService.deleteMember(memberId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}