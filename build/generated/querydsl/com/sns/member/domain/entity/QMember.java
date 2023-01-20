package com.sns.member.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 832669292L;

    public static final QMember member = new QMember("member1");

    public final com.sns.common.QBaseEntity _super = new com.sns.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final StringPath birthday = createString("birthday");

    public final ListPath<com.sns.comment.entity.Comment, com.sns.comment.entity.QComment> comments = this.<com.sns.comment.entity.Comment, com.sns.comment.entity.QComment>createList("comments", com.sns.comment.entity.Comment.class, com.sns.comment.entity.QComment.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final ListPath<com.sns.post.entity.Post, com.sns.post.entity.QPost> post = this.<com.sns.post.entity.Post, com.sns.post.entity.QPost>createList("post", com.sns.post.entity.Post.class, com.sns.post.entity.QPost.class, PathInits.DIRECT2);

    public final StringPath profileImage = createString("profileImage");

    public final ListPath<String, StringPath> roles = this.<String, StringPath>createList("roles", String.class, StringPath.class, PathInits.DIRECT2);

    public final EnumPath<Member.StatusRecode> statusRecode = createEnum("statusRecode", Member.StatusRecode.class);

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

