package ru.croc.course.lesson2;

import ru.croc.course.lesson2.car.Car;
import ru.croc.course.lesson2.parknig.EntryPoint;
import ru.croc.course.lesson2.parknig.ExitPoint;
import ru.croc.course.lesson2.parknig.Parking;
import ru.croc.course.lesson2.parknig.attempt.ParkingAttempt;
import ru.croc.course.lesson2.parknig.attempt.ParkingAttemptResolution;

import java.util.Arrays;

public class ParkingServiceDemoScenario {

    public static void main(String[] args) {
        //Создадим парковку на 10 машин
        Parking parking = new Parking(10);
        EntryPoint entryPoint1 = new EntryPoint(parking, 1, "Въезд 1");
        EntryPoint entryPoint2 = new EntryPoint(parking, 2, "Въезд 2");
        ExitPoint exitPoint1 = new ExitPoint(parking, 1, "Выезд 1");
        ExitPoint exitPoint2 = new ExitPoint(parking, 2, "Выезд 2");
        parking.addEntryPoint(entryPoint1);
        parking.addEntryPoint(entryPoint2);
        parking.addExitPoint(exitPoint1);
        parking.addExitPoint(exitPoint2);

        Car car1 = new Car("A123BC");
        Car car2 = new Car("B234CD");
        Car car3 = new Car("C345DE");

        //Машина заезжает на парковку через въезд 1
        entryPoint1.enter(car1);
        //Машина заезжает на парковку через въезд 2
        entryPoint2.enter(car2);
        //Машина заезжает на парковку через въезд 1
        entryPoint1.enter(car3);

        System.out.println("[Ожидаемое количество свободных мест] - 7");
        System.out.println("[Действительное количество свободных мест] - " + parking.getFreeSpacesCount());
        System.out.println();

        exitPoint1.exit(car1);

        System.out.println("[Ожидаемое количество свободных мест] - 8");
        System.out.println("[Действительное количество свободных мест] - " + parking.getFreeSpacesCount());
        System.out.println();

        System.out.println("[Ожидается, только машина выехала через выезд  1]");
        System.out.println("[Действительный  список выехавших машин через выезд 1]");
        Arrays.stream(exitPoint1.getArrayBasedLeavedCarsLog()).forEach(System.out::println);
        System.out.println();

        System.out.println("[Ожидается, что все машины, за исключением '12-машина' побывали на парковке]");
        System.out.println("[Действительный список заехавших машин через въезд 1]");
        Arrays.stream(entryPoint1.getArrayBasedEntryCarsLog()).forEach(System.out::println);
        System.out.println();

        //Теперь попробуем воссоздать ситуацию, когда машинам будет отказано в паркинге
        Car car4 = new Car("4-машина");
        Car car5 = new Car("5-машина");
        Car car6 = new Car("6-машина");
        Car car7 = new Car("7-машина");
        Car car8 = new Car("8-машина");
        Car car9 = new Car("9-машина");
        Car car10 = new Car("10-машина");
        Car car11 = new Car("11-машина");
        Car car12 = new Car("12-машина");
        entryPoint1.enter(car4);
        entryPoint1.enter(car5);
        entryPoint1.enter(car6);
        entryPoint1.enter(car7);
        entryPoint1.enter(car8);
        entryPoint1.enter(car9);
        entryPoint1.enter(car10);
        entryPoint1.enter(car11);
        entryPoint1.enter(car12);

        System.out.println("[Ожидается, только 12-ая машина не  сможет заехать через]");
        System.out.println("[Действительный список машин, которым отказано в паркинге]");
        Arrays.stream(parking.getArrayBasedParkingAttemptLog(ParkingAttemptResolution.FAILED))
                .map(ParkingAttempt::getLoggingDescription)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("[Ожидается, только 12-ая машина не  сможет заехать через]");
        System.out.println("[Действительный список машин, которым отказано в паркинге]");
        Arrays.stream(parking.getArrayBasedParkingAttemptLog(ParkingAttemptResolution.SUCCEED))
                .map(ParkingAttempt::getLoggingDescription)
                .forEach(System.out::println);



    }

}
