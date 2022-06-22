package com.hello.core.member;

import com.hello.core.AppConfig;
import com.hello.core.service.MemberService;
import com.hello.core.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();

    /*
    조금 더 일반적인 상황이라고 가정
    회원 가입 실패 케이스
    - 중복 회원 : 동일한 이메일, 아이디가 존재할 경우
     */
    @DisplayName("회원가입_성공")
    @Test
    void 회원가입_성공(){
        // given
        Member member = new Member(1L, "memberA", Grade.BASIC);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }



}
