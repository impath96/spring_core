package com.hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    // 동시성 문제 : ConcurrentHashMap 활용
    private static Map<Long, Member> store = new HashMap<>();

    // 회원 저장
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    // id로 회원 조회
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
