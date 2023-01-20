package com.sns.member.mapper;

import com.sns.member.domain.entity.Member;
import com.sns.member.domain.entity.Member.StatusRecode;
import com.sns.member.dto.RequestDto.Patch;
import com.sns.member.dto.RequestDto.Post;
import com.sns.member.dto.ResponseDto.Response;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-21T01:10:13+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member postToMember(Post post) {
        if ( post == null ) {
            return null;
        }

        Member member = new Member();

        member.setEmail( post.getEmail() );
        member.setPassword( post.getPassword() );
        member.setName( post.getName() );
        member.setNickname( post.getNickname() );
        member.setPhone( post.getPhone() );
        member.setAddress( post.getAddress() );
        member.setBirthday( post.getBirthday() );
        member.setProfileImage( post.getProfileImage() );

        return member;
    }

    @Override
    public Member patchToMember(Patch patch) {
        if ( patch == null ) {
            return null;
        }

        Member member = new Member();

        member.setMemberId( patch.getMemberId() );
        member.setEmail( patch.getEmail() );
        member.setPassword( patch.getPassword() );
        member.setName( patch.getName() );
        member.setNickname( patch.getNickname() );
        member.setPhone( patch.getPhone() );
        member.setAddress( patch.getAddress() );
        member.setBirthday( patch.getBirthday() );
        member.setProfileImage( patch.getProfileImage() );
        member.setStatusRecode( patch.getStatusRecode() );

        return member;
    }

    @Override
    public Response memberToResponse(Member member) {
        if ( member == null ) {
            return null;
        }

        long memberId = 0L;
        String email = null;
        String password = null;
        String name = null;
        String phone = null;
        String nickname = null;
        String birthday = null;
        String address = null;
        String profileImage = null;
        StatusRecode statusRecode = null;

        memberId = member.getMemberId();
        email = member.getEmail();
        password = member.getPassword();
        name = member.getName();
        phone = member.getPhone();
        nickname = member.getNickname();
        birthday = member.getBirthday();
        address = member.getAddress();
        profileImage = member.getProfileImage();
        statusRecode = member.getStatusRecode();

        Integer age = null;
        List<Member> members = null;

        Response response = new Response( memberId, email, password, name, phone, nickname, age, birthday, address, profileImage, members, statusRecode );

        return response;
    }

    @Override
    public List<Response> MembersToResponse(List<Member> members) {
        if ( members == null ) {
            return null;
        }

        List<Response> list = new ArrayList<Response>( members.size() );
        for ( Member member : members ) {
            list.add( memberToResponse( member ) );
        }

        return list;
    }
}
