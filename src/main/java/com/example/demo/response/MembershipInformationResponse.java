package com.example.demo.response;

/**
 * @since       2021.07.04
 * @author      민경수
 * @description membership information response
 **********************************************************************************************************************/
import com.example.demo.dto.response.MembershipInfomationDTO;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MembershipInformationResponse {
    private Boolean success;
    private MembershipInfomationDTO response;
    private RuntimeException error;
}