package com.example.demo.response;

/**
 * @since       2021.07.04
 * @author      민경수
 * @description membership point response
 **********************************************************************************************************************/
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MembershipPointResponse {
    private Boolean success;
    private Boolean response;
    private RuntimeException error;

}