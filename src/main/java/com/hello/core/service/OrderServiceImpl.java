package com.hello.core.service;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.member.Member;
import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemoryMemberRepository;
import com.hello.core.order.Order;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    // SRP가 잘 지켜져 있다.
    // SRP가 잘 준수되어 있지 않을 경우
    // 만약 할인 정책이 변경되었을 때
    // OrderService를 고쳐야 한다.
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        // 먼저 회원 정보 조회
        Member member = memberRepository.findById(memberId);

        // 할인 정책 수행
        int disCountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, disCountPrice);
    }
}
