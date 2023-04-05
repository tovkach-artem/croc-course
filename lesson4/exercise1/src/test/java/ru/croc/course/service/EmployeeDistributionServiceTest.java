package ru.croc.course.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.croc.course.entiry.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Класс тестирует функциональность сервиса {@link EmployeeDistributionService} */
public class EmployeeDistributionServiceTest {
    private static final Employee DIRECTOR_1 = new Employee(1, "e1", null);
    private static final Employee DIRECTOR_2 = new Employee(2, "e3", null);
    private static final Employee DIRECTOR_3 = new Employee(3, "e3", null);
    private static final Employee EMPLOYEE4 = new Employee(4, "e4", DIRECTOR_1);
    private static final Employee EMPLOYEE5 = new Employee(5, "e5", DIRECTOR_2);
    private static final Employee EMPLOYEE6 = new Employee(6, "e6", DIRECTOR_3);
    private static final Employee EMPLOYEE7 = new Employee(7, "e7", EMPLOYEE4);
    private static final Employee EMPLOYEE8 = new Employee(8, "e8", EMPLOYEE5);
    private static final Employee EMPLOYEE9 = new Employee(9, "e9", EMPLOYEE6);
    private static final Employee EMPLOYEE10 = new Employee(10, "e10", EMPLOYEE7);
    private final EmployeeDistributionService employeeDistributionService = new EmployeeDistributionService();


    /** Данный тест позволяет убедиться, что определение директоров и полного списка
     * их подчиненных на основе разрозненных данных о сотрудниках происходит корректно.
     */
    @Test
    void shouldReturnDirectorsAssociatedToAllSubordinates() {
        Map<Employee, List<Employee>> expected = new HashMap<>();
        expected.put(DIRECTOR_1, List.of(EMPLOYEE4, EMPLOYEE7, EMPLOYEE10));
        expected.put(DIRECTOR_2, List.of(EMPLOYEE5, EMPLOYEE8));
        expected.put(DIRECTOR_3, List.of(EMPLOYEE6, EMPLOYEE9));

        Map<Employee, List<Employee>> actual = employeeDistributionService.getDirectorsAssociatedToAllSubordinates(getTestEmployees());

        Assertions.assertThat(actual).containsAllEntriesOf(expected);
        Assertions.assertThat(actual.keySet()).hasSize(3);
    }
    /** Данный тест позволяет убедиться, что определение списка директоров отсортированных по количеству
     * общих подчиненны и имени руководителя на основании разрозненных данных о сотрудниках происходит корректно.
     */
    @Test
    void shouldReturnDirectorsSortedBySubordinatesCountAndName() {
        List<Employee> actual = employeeDistributionService.getSortedDirectorsByAllSubordinatesCountAndName(getTestEmployees());

        Assertions.assertThat(actual.get(0)).isEqualTo(DIRECTOR_1);
        Assertions.assertThat(actual.get(1)).isEqualTo(DIRECTOR_2);
        Assertions.assertThat(actual.get(2)).isEqualTo(DIRECTOR_3);
        Assertions.assertThat(actual).hasSize(3);
    }
    /** Данный тест позволяет убедиться, что определение менеджеров и списка их непосредственных
     * подчиненных на основании разрозненных данных о сотрудниках происходит корректно.
     */
    @Test
    void shouldReturnManagersAssociatedToDirectSubordinates() {
        Map<Employee, List<Employee>> expected = new HashMap<>();
        expected.put(DIRECTOR_1, List.of(EMPLOYEE4));
        expected.put(DIRECTOR_2, List.of(EMPLOYEE5));
        expected.put(DIRECTOR_3, List.of(EMPLOYEE6));
        expected.put(EMPLOYEE4, List.of(EMPLOYEE7));
        expected.put(EMPLOYEE5, List.of(EMPLOYEE8));
        expected.put(EMPLOYEE6, List.of(EMPLOYEE9));
        expected.put(EMPLOYEE7, List.of(EMPLOYEE10));

        Map<Employee, List<Employee>> actual = employeeDistributionService.getManagersAssociatedToDirectSubordinates(getTestEmployees());

        Assertions.assertThat(actual.keySet()).containsAll(expected.keySet());
        Assertions.assertThat(actual).containsAllEntriesOf(expected);
        Assertions.assertThat(actual.keySet()).hasSize(7);
    }

    /**
     * Формирует список тестовых данных, имитирующий разрозненные данные о сотрудниках.
     */
    static List<Employee> getTestEmployees() {
        return List.of(DIRECTOR_1, DIRECTOR_2, DIRECTOR_3, EMPLOYEE4, EMPLOYEE5, EMPLOYEE6, EMPLOYEE7, EMPLOYEE8, EMPLOYEE9, EMPLOYEE10);
    }
}

