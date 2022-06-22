package com.hello.core;

import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.member.MemoryMemberRepository;
import com.hello.core.service.MemberService;
import com.hello.core.service.MemberServiceImpl;
import com.hello.core.service.OrderService;
import com.hello.core.service.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
