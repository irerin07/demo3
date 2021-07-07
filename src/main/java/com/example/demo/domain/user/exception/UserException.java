package com.example.demo.domain.user.exception;

/**
 * @since       2021.07.04
 * @author      민경수
 * @description user exception
 **********************************************************************************************************************/
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserException extends RuntimeException{
    private String msg;
    private int code;
}