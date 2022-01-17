package enumtype.extendEnum;

import java.util.Collection;
import java.util.List;

public class extendEnumMain {
    public static void main(String[] args) {
        double x = 5.5;
        double y = 6.6;

        testCalculate(List.of(ExtendedOperation.values()), x, y);
        System.out.println("-------------");
        testCalculate(List.of(BasicOperation.values()), x, y);
    }

    static void testCalculate(Collection<? extends Operation> operations, double x, double y) {
        for (Operation op : operations) {
            System.out.printf("연산식 : %f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
