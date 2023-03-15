import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum SizeUnitBinaryPostfixes {
    B(1L),
    KB(B.unitBase << 10),
    MB(KB.unitBase<< 10),
    GB(MB.unitBase << 10),
    TB(GB.unitBase << 10),
    PB(TB.unitBase << 10),
    EB(PB.unitBase << 10);

    private final Long unitBase;

    public static List<SizeUnitBinaryPostfixes> unitsInDescending() {
        List<SizeUnitBinaryPostfixes> list = Arrays.asList(values());
        Collections.reverse(list);
        return list;
    }

    SizeUnitBinaryPostfixes(Long unitBase) {
        this.unitBase = unitBase;
    }

    public Long getUnitBase() {
        return unitBase;
    }
}
