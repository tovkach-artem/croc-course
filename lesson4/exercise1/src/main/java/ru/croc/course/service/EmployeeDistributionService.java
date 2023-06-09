package ru.croc.course.service;

import ru.croc.course.entiry.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/** Сервис распределения сотрудников:
 * Данный сервис используется, когда у необходимо
 * обработать набор разрозненных данных о сотрудниках.
 */
public class EmployeeDistributionService {

    /**
     * Метод возвращает директоров организаций и всех подчиненных ему сотрудников.
     * Под "ВСЕХ" понимается весь список иерархии сотрудников, находящихся
     * в подчинении, а не только непосредственных подчиненных.
     */
    public Map<Employee, List<Employee>> getDirectorsAssociatedToAllSubordinates(List<Employee> mixedEmployees) {
        return mixedEmployees.stream()
                .filter(Employee::isDirector)
                .collect(Collectors.toMap(employee -> employee,employee -> getAllSubordinates(employee, mixedEmployees)));
    }

    /**
     * Метод возвращает всех сотрудников, которые находятся в подчинении у заданного.
     * Под "ВСЕХ" понимается весь список иерархии сотрудников, находящихся
     * в подчинении, а не только непосредственных подчиненных.
     */
    public List<Employee> getAllSubordinates(Employee employee, List<Employee> mixedEmployees) {
        Map<Employee, List<Employee>> managersToSubordinates = getManagersAssociatedToDirectSubordinates(mixedEmployees);
        List<Employee> directorToSubordinates = new ArrayList<>();
        if (managersToSubordinates.containsKey(employee)) {
            for (Employee subordinate : managersToSubordinates.get(employee)) {
                directorToSubordinates.add(subordinate);
                directorToSubordinates.addAll(getAllSubordinates(subordinate, mixedEmployees));
            }
        }
        return directorToSubordinates;
    }
    /**
     * Метод возвращает менеджеров и их непосредственных подчиненных.
     */
    public Map<Employee, List<Employee>> getManagersAssociatedToDirectSubordinates(List<Employee> mixedEmployees) {
        Map<Employee, List<Employee>> managersToDirectSubordinates = new HashMap<>();
        for (Employee employee : mixedEmployees) {
            if (employee.isDirector()) {
                managersToDirectSubordinates.put(employee, new ArrayList<>());
            } else {
                Employee manager = employee.getManager();
                if (managersToDirectSubordinates.containsKey(manager)) {
                    managersToDirectSubordinates.get(manager).add(employee);
                } else {
                    List<Employee> subordinates = new ArrayList<>();
                    subordinates.add(employee);
                    managersToDirectSubordinates.put(manager, subordinates);
                }
            }
        }
        return managersToDirectSubordinates;
    }

    /**
     * Метод возвращает отсортированный список директоров по общему количеству их подчиненных и имени руководителя:
     * Под "общим" понимается весь список иерархии сотрудников, находящихся
     * в подчинении, а не только непосредственных подчиненных.
     */
    public List<Employee> getSortedDirectorsByAllSubordinatesCountAndName(List<Employee> mixedEmployees) {
        Map<Employee, List<Employee>> directorsAssociatedToAllSubordinates = getDirectorsAssociatedToAllSubordinates(mixedEmployees);
        List<Employee> sortedDirectorsByAllSubordinatesCountAndName = new ArrayList<>(directorsAssociatedToAllSubordinates.keySet());
        sortedDirectorsByAllSubordinatesCountAndName.sort((employee1, employee2) -> {
            int subordinates1 = directorsAssociatedToAllSubordinates.get(employee1).size();
            int subordinates2 = directorsAssociatedToAllSubordinates.get(employee2).size();
            if(subordinates1 != subordinates2) {
                return subordinates2 - subordinates1;
            } else {
                return employee1.getName().compareTo(employee2.getName());
            }
        });
        return sortedDirectorsByAllSubordinatesCountAndName;
    }

}
