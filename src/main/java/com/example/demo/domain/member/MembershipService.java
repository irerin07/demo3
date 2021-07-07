package com.example.demo.domain.member;

/**
 * @since       2021.07.04
 * @author      민경수
 * @description member service
 **********************************************************************************************************************/
import java.util.List;

import com.example.demo.domain.member.query.MemberRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MembershipService {

    private final MemberRepository memberRepository;


    public List<Member> findAllMembershipByUserId(String userId) {
        return memberRepository.findAllMembershipByUserId(userId);
    }

    public Member save(Member member) {
        return memberRepository.save(member);
    }

    public Member findMembershipByMembershipIdAndUserId(String membershipId, String userId) {
        return memberRepository.findMembershipByMembershipIdAndUserId(membershipId, userId);
    }

    public Member findActiveMembershipByMembershipIdAndUserId(String membershipId, String userId) {
        return memberRepository.findActiveMembershipByMembershipIdAndUserId(membershipId, userId);
    }

}