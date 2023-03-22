package ru.croc.course.lesson2.support;

import java.util.Arrays;

public class ArrayOperations {

    private static final int DEFAULT = 2;

    public static <T> T[] getIncreasedSizeArray(T[] array) {
        T[] newArray = Arrays.copyOf(array, array.length * DEFAULT);
        return newArray;
    }

    public  static <T> T[] getFullnessSizeBasedArray(int fullness, T[] array) {
        if(fullness  ==  array.length) {
            return getIncreasedSizeArray(array);
        }
        return array;
    }

}
