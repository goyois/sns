package com.sns.member.mapper;

import com.sns.member.dto.RequestDto;
import com.sns.member.dto.ResponseDto;
import com.sns.member.domain.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member postToMember(RequestDto.Post post);
    Member patchToMember(RequestDto.Patch patch);
    ResponseDto.Response memberToResponse(Member member);
}
