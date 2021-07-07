package com.example.demo.response;

/**
 * @since       2021.07.04
 * @author      민경수
 * @description save membership response
 **********************************************************************************************************************/
import com.example.demo.dto.response.SavedMembershipDTO;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaveMembershipResponse {
    private Boolean success;
    private SavedMembershipDTO response;
    private RuntimeException error;
}