package com.example.demo.util;

/**
 * @since       2021.07.04
 * @author      민경수
 * @description list utils
 **********************************************************************************************************************/
import java.util.Collection;

public class ListUtils {

    public static Boolean isEmpty(Collection<?> coll){
        return (coll == null || coll.size() == 0);
    }

}