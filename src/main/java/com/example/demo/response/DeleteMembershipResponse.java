package com.example.demo.response;

/**
 * @since       2021.07.04
 * @author      민경수
 * @description delete membership dto
 **********************************************************************************************************************/
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeleteMembershipResponse {
    private Boolean success;
    private Boolean response;
    private RuntimeException error;
}