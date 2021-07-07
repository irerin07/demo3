package com.example.demo.domain.member.query;

/**
 * @since       2021.07.04
 * @author      민경수
 * @description member repository
 **********************************************************************************************************************/
import java.util.List;

import com.example.demo.domain.member.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String>{

    @Query(value = "select m from Member m join fetch m.user u where m.user.userId =:userId")
    List<Member> findAllMembershipByUserId(@Param(value = "userId") String userId);

    @Query(value = "select m from Member m join fetch m.user u where m.membershipId =:membershipId and u.userId =:userId")
    Member findMembershipByMembershipIdAndUserId(@Param(value = "membershipId") String membershipId, @Param(value = "userId") String useuserIdrId);

    @Query(value = "select m from Member m join fetch m.user u where m.membershipId =:membershipId and u.userId =:userId and m.membershipStatus ='Y'")
    Member findActiveMembershipByMembershipIdAndUserId(@Param(value = "membershipId") String membershipId, @Param(value = "userId") String useuserIdrId);



}