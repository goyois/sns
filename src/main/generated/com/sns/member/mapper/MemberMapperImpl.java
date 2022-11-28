package com.sns.member.mapper;

import com.sns.member.domain.entity.Member;
import com.sns.member.dto.RequestDto.Patch;
import com.sns.member.dto.RequestDto.Post;
import com.sns.member.dto.ResponseDto.Response;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-28T23:24:45+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Azul Systems, Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member postToMember(Post post) {
        if ( post == null ) {
            return null;
        }

        Member member = new Member();

        member.setName( post.getName() );
        member.setEmail( post.getEmail() );
        member.setPassword( post.getPassword() );
        member.setPhone( post.getPhone() );
        member.setAddress( post.getAddress() );

        return member;
    }

    @Override
    public Member patchToMember(Patch patch) {
        if ( patch == null ) {
            return null;
        }

        Member member = new Member();

        member.setMemberId( patch.getMemberId() );
        member.setName( patch.getName() );
        member.setEmail( patch.getEmail() );
        member.setPassword( patch.getPassword() );
        member.setNickname( patch.getNickname() );
        member.setAddress( patch.getAddress() );
        member.setBirthday( patch.getBirthday() );
        member.setProfileImage( patch.getProfileImage() );

        return member;
    }

    @Override
    public Response memberToResponse(Member member) {
        if ( member == null ) {
            return null;
        }

        long memberId = 0L;
        String name = null;
        String password = null;
        String email = null;
        String phone = null;
        String address = null;
        String profileImage = null;
        String role = null;

        memberId = member.getMemberId();
        name = member.getName();
        password = member.getPassword();
        email = member.getEmail();
        phone = member.getPhone();
        address = member.getAddress();
        profileImage = member.getProfileImage();
        role = member.getRole();

        Response response = new Response( memberId, name, password, email, phone, address, profileImage, role );

        return response;
    }
}
