import java.util.List;

public class UnitBinaryService {


    public static void printBytes(long size, boolean requiredHumanReadable) {
        if (size < 0) {
            throw new IllegalArgumentException("Неверный размер файла " + size);
        }
        if(requiredHumanReadable) {
            System.out.println(toHumanReadable(size));
        } else {
            System.out.println(String.format("%.1f %s", (double) size, SizeUnitBinaryPostfixes.B.name()));
        }
    }

    public static void printBytes(long size) {
        printBytes(size, true);
    }

    private static String toHumanReadable(long size) {
        List<SizeUnitBinaryPostfixes> units = SizeUnitBinaryPostfixes.unitsInDescending();

        String result = null;
        for (SizeUnitBinaryPostfixes unit : units) {
            if (size >= unit.getUnitBase()) {
                result = formatSize(size, unit.getUnitBase(), unit.name());
                break;
            }
        }
        return result == null
                ? formatSize(size, SizeUnitBinaryPostfixes.B.getUnitBase(), SizeUnitBinaryPostfixes.B.name())
                : result;
    }

    private static String formatSize(long size, long divider, String unitName) {
        return String.format("%.1f %s", (double) size / divider, unitName);
    }

}
