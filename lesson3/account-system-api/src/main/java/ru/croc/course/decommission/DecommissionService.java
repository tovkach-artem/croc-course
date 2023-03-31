package ru.croc.course.decommission;

import java.util.List;

public interface DecommissionService<T extends Serviceable> {

    boolean writeOff(T serviceable);
    List<T> getAllDecommissioned();

}
