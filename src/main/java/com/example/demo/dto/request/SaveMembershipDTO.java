package com.example.demo.dto.request;

/**
 * @since       2021.07.04
 * @author      민경수
 * @description save membership dto
 **********************************************************************************************************************/
import lombok.*;
import javax.validation.constraints.Min;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaveMembershipDTO {

    @NonNull
    private String membershipId;

    @NonNull
    private String membershipName;

    @Min(value = 0)
    @NonNull
    private Integer point;
}