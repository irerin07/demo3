package com.example.demo.error;

/**
 * @author 민경수
 * @description validation error dto
 * @since 2021.07.04
 **********************************************************************************************************************/
import java.util.*;

import org.springframework.validation.FieldError;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ValidationErrorDTO {
    private List<FieldErrorDTO> fieldErrors = new ArrayList<>();


    public void addFieldError(String path, String message) {
        FieldErrorDTO error = new FieldErrorDTO(path, message);
        fieldErrors.add(error);
    }

}