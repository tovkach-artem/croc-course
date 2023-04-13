package ru.croc.course.support.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Сервис для работы с записью/чтением объектов в/из файла
 */
public class ObjectIOManipulationService<T extends Serializable> {

    /**
     * Записывает список объектов в файл
     */
    public void writeObjectsToFile(List<T> objects, File file) throws IOException {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(objects);
            objectOutputStream.flush();
        }
    }
    /**
     * Считывает список объектов из файла
     */
    public List<T> readObjectsFromFile(File file) throws IOException, ClassNotFoundException {
        List<T> objects = new ArrayList<T>();
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))){
            objects = (List<T>) objectInputStream.readObject();
        }
        return objects;
    }


}
