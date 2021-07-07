package com.example.demo.domain.member;

/**
 * @since       2021.07.04
 * @author      민경수
 * @description member
 **********************************************************************************************************************/
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.domain.user.User;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.*;

@Builder
@Entity
@Table(name = "tb_member")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@DynamicUpdate
@Getter
public class Member {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEQ")
    private Long seq;

    @Id
    @Column(name = "MEMBERSHIP_ID")
    private String membershipId;

    @Column(name = "MEMBERSHIP_NAME")
    private String membershipName;
    @Column(name = "START_DATE")
    private LocalDateTime startDate;
    @Column(name = "MEMBERSHIP_STATUS")
    private String membershipStatus;
    @Column(name = "POINT")
    private Integer point;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public static Member of(String membershipId, String membershipName, int point, User user) {

        return Member.builder()
                .user(user)
                .membershipId(membershipId)
                .membershipName(membershipName)
                .point(point)
                .startDate(LocalDateTime.now())
                .membershipStatus("Y")
                .build();
    }

    public void updatePoint(int amount) {
        this.point += amount;
    }

    public void updateStatus(String status) {
        this.membershipStatus = status;
    }

}