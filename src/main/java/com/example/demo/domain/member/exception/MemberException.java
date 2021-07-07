package com.example.demo.domain.member.exception;

/**
 * @since       2021.07.04
 * @author      민경수
 * @description member exception
 **********************************************************************************************************************/
import lombok.*;

@Getter
@AllArgsConstructor
public class MemberException extends RuntimeException{
    private String msg;
    private int code;

}