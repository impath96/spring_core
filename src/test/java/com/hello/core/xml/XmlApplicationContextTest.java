package com.hello.core.xml;

import com.hello.core.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class XmlApplicationContextTest {

    @Test
    void xmlAppContext(){

       ApplicationContext ac =  new GenericXmlApplicationContext("appConfig.xml");
       MemberService memberService = ac.getBean("memberService", MemberService.class);
       assertThat(memberService).isInstanceOf(MemberService.class);

    }
}
