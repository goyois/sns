package com.sns.security.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//시큐리티 필터에서 사용할 수 있도록 역직렬화 DTO 클래스
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoginDao {
    private String username;
    private String password;
}
