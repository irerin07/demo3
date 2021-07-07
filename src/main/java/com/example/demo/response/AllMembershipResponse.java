package com.example.demo.response;

/**
 * @since       2021.07.04
 * @author      민경수
 * @description all membership response
 **********************************************************************************************************************/
import java.util.List;

import com.example.demo.dto.response.AllMembershipDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AllMembershipResponse {
    private Boolean success;
    private List<AllMembershipDTO> allMembershipDTO;
    private RuntimeException error;

    public AllMembershipResponse(Boolean success, List<AllMembershipDTO> allMembershipDTO, RuntimeException error){
        this.success = success;
        this.allMembershipDTO = allMembershipDTO;
        this.error = error;
    }

}