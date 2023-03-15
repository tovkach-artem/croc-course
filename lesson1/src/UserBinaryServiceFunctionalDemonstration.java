import java.util.HashMap;
import java.util.Map;

public class UserBinaryServiceFunctionalDemonstration {

    private static Map<Long, String> TEST_DATA = new HashMap<>();

    static {
        TEST_DATA.put(0L, "0.0 B");
        TEST_DATA.put(1023L, "1023.0 B");
        TEST_DATA.put(1024L, "1.0 KB");
        TEST_DATA.put(12_345L, "12.1 KB");
        TEST_DATA.put(10_123_456L, "9.7 MB");
        TEST_DATA.put(10_123_456_798L, "9.4 GB");
        TEST_DATA.put(1_777_777_777_777_777_777L, "1.5 EB");
    }

    public static void main(String[] args) {
        for (Map.Entry<Long, String> entry : TEST_DATA.entrySet()) {
            System.out.println("|-Начало-тестового-сценария-|");
            System.out.println("    |-На вход поступило значение: " + entry.getKey());
            System.out.println("    |-Ожидаемые данные: " + entry.getValue());
            System.out.print("    |-Актуальные данные: ");
            UnitBinaryService.printBytes(entry.getKey());
            System.out.println("|-Конец-тестового-сценария-|");
            System.out.println("----------------------------");
        }
    }

}
