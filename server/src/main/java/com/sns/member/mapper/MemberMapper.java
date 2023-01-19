package com.sns.member.mapper;

import com.sns.member.domain.entity.Member;
import com.sns.member.dto.RequestDto;
import com.sns.member.dto.ResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member postToMember(RequestDto.Post post);
    Member patchToMember(RequestDto.Patch patch);
    ResponseDto.Response memberToResponse(Member member);
<<<<<<< HEAD:server/src/main/java/com/sns/member/mapper/MemberMapper.java

    ResponseDto.ResponseMain memberToResponseMain(Member member);
=======
>>>>>>> 55624373aac4732eb1e92a4c9bc6e9fed8791ace:src/main/java/com/sns/member/mapper/MemberMapper.java
    List<ResponseDto.Response> MembersToResponse(List<Member> members);

}
