package com.example.demo.dto.response;

/**
 * @since       2021.07.04
 * @author      민경수
 * @description all membership dto
 **********************************************************************************************************************/
import java.time.LocalDateTime;

import com.example.demo.domain.member.Member;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AllMembershipDTO {

    private Long seq;
    private String membershipId;
    private String userId;
    private String membershipName;
    private LocalDateTime startDate;
    private String membershipStatus;
    private Integer point;

    public AllMembershipDTO(Member member){
        this.seq = member.getSeq();
        this.membershipId = member.getMembershipId();
        this.userId = member.getUser().getUserId();
        this.membershipName = member.getMembershipName();
        this.startDate = member.getStartDate();
        this.membershipStatus = member.getMembershipStatus();
        this.point = member.getPoint();
    }

    //ModelMapper 사용?
    // public static AllMembershipDTO of(Member member){
    //     ModelMapperUtil.getModelMapper.map(Member, AllMembershipDTO.class);
    // }

}