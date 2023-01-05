package snsower.sns.member.mapper;

import org.mapstruct.Mapper;
import snsower.sns.member.domain.entity.Member;
import snsower.sns.member.dto.RequestDto;
import snsower.sns.member.dto.ResponseDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member postToMember(RequestDto.Post post);
    Member patchToMember(RequestDto.Patch patch);
    ResponseDto.Response memberToResponse(Member member);
    List<ResponseDto.Response> MembersToResponse(List<Member> members);

}