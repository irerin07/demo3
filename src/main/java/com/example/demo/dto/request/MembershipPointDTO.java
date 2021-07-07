package com.example.demo.dto.request;

/**
 * @since       2021.07.04
 * @author      민경수
 * @description membership point dto
 **********************************************************************************************************************/
import lombok.Getter;
import lombok.NonNull;

@Getter
public class MembershipPointDTO {

    @NonNull
    private String membershipId;
    @NonNull
    private Integer amount;

}