package com.hello.core.beanfind;

import com.hello.core.AppConfig;
import com.hello.core.service.MemberService;
import com.hello.core.service.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ApplicationContextBasicBeanTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        // System.out.println("memberService = " + memberService);
        // System.out.println("memberService.getClass = " + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("타입으로 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        // System.out.println("memberService = " + memberService);
        // System.out.println("memberService.getClass = " + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("구체타입으로 조회")
    void findBeanByImplType(){
        MemberService memberService = ac.getBean(MemberServiceImpl.class);
        // System.out.println("memberService = " + memberService);
        // System.out.println("memberService.getClass = " + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("빈 이름으로 조회 X")
    void notFindBeanByName(){

        // NoSuchBeanDefinitionException 예외가 발생하는가?
        assertThrows(NoSuchBeanDefinitionException.class,
                ()-> ac.getBean("xxx", MemberServiceImpl.class));

    }

}
