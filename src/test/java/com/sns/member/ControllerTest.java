//package com.sns.member;
//
//
//import com.google.gson.Gson;
//import com.sns.member.dto.RequestDto;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@Transactional
//@SpringBootTest  //Application Context 생성
//@AutoConfigureMockMvc  //Controller Test를 위한 application 자동 구성
//public class ControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private Gson gson;
//
//    @Test
//    void postMemberTest() throws Exception {
//        //given
//        RequestDto.Post post = new RequestDto.Post("김주원","1234","komi3391@gmail.com",
//                "010-9197-3400","kim","의정부시","12월 8일",12);
//        String content = gson.toJson(post);
//
//
//        //when
//        ResultActions actions =
//                mockMvc.perform(
//                        post("/api/v1/members")
//                                .accept(MediaType.APPLICATION_JSON)
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(content)
//                );
//
//
//        // then
//        MvcResult result = actions
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.data.name").value(post.getName()))
//                .andExpect(jsonPath("$.data.password").value(post.getPassword()))
//                .andExpect(jsonPath("$.data.email").value(post.getEmail()))
//                .andExpect(jsonPath("$.data.phone").value(post.getPhone()))
//                .andExpect(jsonPath("$.data.nickname").value(post.getNickname()))
//                .andExpect(jsonPath("$.data.address").value(post.getAddress()))
//                .andExpect(jsonPath("$.data.birthday").value(post.getBirthday()))
//                .andExpect(jsonPath("$.data.profileImage").value(post.get()))
//                .andReturn();
//
//        System.out.println(result.getResponse().getContentAsString());
//    }
//
//        //given 테스트용 request body 생성
//
//        //when MockMvc 객체로 테스트 대상 Controller  호츌
//
//        //then Controller 핸들러 메서드에서 응답으로 수신한 HTTP Status 및 response body 검증
//}
