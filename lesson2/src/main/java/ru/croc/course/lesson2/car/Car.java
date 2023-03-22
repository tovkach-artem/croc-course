package ru.croc.course.lesson2.car;

/**
 * Класс машина
 */

public class Car {
    /** номер машины*/
    private String number;

    /** конструктор класса машина, позволяющий задать ей номер при создании */
    public Car(String number) {
        this.number = number;
    }
    /** геттер для полян номер
     * @return номер машины
     */
    public String getNumber() {
        return number;
    }
    /** сеттер для полян номер
     * @param  number новое значение для поля номер
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /** @return информация о машине в удобном для отображения виде */
    @Override
    public String toString() {
        return "Машина{" +
                "номер='" + number + '\'' +
                '}';
    }
}
