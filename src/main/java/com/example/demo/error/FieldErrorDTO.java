package com.example.demo.error;

/**
 * @since       2021.07.04
 * @author      민경수
 * @description field error dto
 **********************************************************************************************************************/
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FieldErrorDTO {

    private String field;

    private String message;

}