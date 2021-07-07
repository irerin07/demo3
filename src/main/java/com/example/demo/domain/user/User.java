package com.example.demo.domain.user;

/**
 * @since       2021.07.04
 * @author      민경수
 * @description user
 **********************************************************************************************************************/
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.domain.member.Member;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.*;


@Entity
@Table(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@DynamicUpdate
@Getter
public class User {

    @Column(name = "seq")
    private Long seq;

    @Id
    @Column(name = "USER_ID")
    private String userId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Member> members;


}