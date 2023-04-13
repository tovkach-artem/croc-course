package ru.croc.course.support.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectIOManipulationService<T extends Serializable> {

    public void writeObjectsToFile(List<T> objects, File file) throws IOException {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(objects);
            objectOutputStream.flush();
        }
    }

    public List<T> readObjectsFromFile(File file) throws IOException, ClassNotFoundException {
        List<T> objects = new ArrayList<T>();
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))){
            objects = (List<T>) objectInputStream.readObject();
        }
        return objects;
    }


}
