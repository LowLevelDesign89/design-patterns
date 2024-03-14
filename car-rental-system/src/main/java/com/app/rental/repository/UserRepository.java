package com.app.rental.repository;

import com.app.rental.models.entity.Account;
import com.app.rental.models.entity.Member;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepository {
    private AtomicLong userId = new AtomicLong(1l);
    private Map<Long, Account> users = new HashMap<>();

    public Member save(Member member) {
        if(member.getId() == null) {
            member.setId(userId.get());
            userId.incrementAndGet();
        }
        users.put(member.getId(), member);
        return member;
    }

    public Optional<Member> findById(Long id) {
        Member member = (Member) users.get(id);
        return (member == null) ? Optional.empty(): Optional.of(member);
    }
}
