package ru.croc.course.lesson2.support;

import java.util.Arrays;

/**
 * Класс для вынесения общей логики по работе с массивами
 */
public class ArrayOperations {
    /** Значения по умолчанию для расширения размера массива */
    private static final int DEFAULT_MULTIPLY_VALUE = 2;

    /**
     * Увеличивает размер массива заданного массива
     * @param array исходный массив
     * @param <T> значение обобщенного типа для массива элементов
     * @return новый массив со скопированным элементами, но увеличивает его размерность в {@link ArrayOperations#DEFAULT_MULTIPLY_VALUE} раз
     */
    public static <T> T[] getIncreasedSizeArray(T[] array) {
        T[] newArray = Arrays.copyOf(array, array.length * DEFAULT_MULTIPLY_VALUE);
        return newArray;
    }

    /**
     * Увеличивает размер массива, если это необходимо. Решение о расширении принимает на основании заполненности
     * @param fullness заполненность массива
     * @param array исходный массив
     * @param <T> значение обобщенного типа для массива элементов
     * @return либо новый массив со скопированным элементами,
     * но увеличивает его размерность в {@link ArrayOperations#DEFAULT_MULTIPLY_VALUE} раз,
     * либо просто старый массив
     */
    public  static <T> T[] getFullnessSizeBasedArray(int fullness, T[] array) {
        if(fullness  ==  array.length) {
            return getIncreasedSizeArray(array);
        }
        return array;
    }

}
