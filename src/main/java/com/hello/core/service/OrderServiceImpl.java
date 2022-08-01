package com.hello.core.service;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.member.Member;
import com.hello.core.member.MemberRepository;
import com.hello.core.order.Order;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository; //  = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // 하지만 이러면 OCP 위반 아닌가?

    private final DiscountPolicy discountPolicy; // 결국 최종적으로 이러한 형태여야 한다.

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /*
    *  1) DIP 위반 (인터페이스(추상)에 의존하고, 구현체에는 의존 X)
    * 주문 서비스 클라이언트는 DiscountPolicy의 인터페이스에 의존하는 것 같지만
    * 문제는 new RateDiscountPolicy() 즉, 구현 클래스에도 의존하고 있다. (FixDiscountPolicy도 마찬가지)
    *
    *  2) OCP 위반 (변경하지 않고 확장 가능해야 한다)
    *  결국 기능을 확장/변경을 하는데 클라이언트의 코드에 영향이 간다
    *   FixDiscountPolicy() -> RateDiscountPolicy()
    *
    * */
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

    // 테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
