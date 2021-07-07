package com.example.demo;

/**
 * @since       2021.07.04
 * @author      민경수
 * @description provider
 **********************************************************************************************************************/
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Provider {

    @AliasFor(annotation = Component.class)
    String value() default "";
}