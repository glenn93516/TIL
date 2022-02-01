package methods;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ArgumentValidation {

    /**
     * @throws ArithmeticException when m <= 0
     */
    public void useDocument(BigInteger m) {
        // Objects.requireNonNull()을 사용하면 null 체크 가능
        Objects.requireNonNull(m, "message");

        // m == null 인 경우 NPE가 발생하나, 해당 예외는 BigInteger 레벨에 기술되어 있기 때문에 생략
        if (m.signum() <= 0) {
            throw  new ArithmeticException("m은 양수여야 합니다" + m);
        }
    }

    void assertTest(Integer a) {
        // validation
        assert a != null;
        assert a.intValue() >= 0;

        // do something
    }

    void notNecessaryValidation(List<CompareTest> list) {
        // 불필요한 validation
        // sort할 때 비교 불가능한 경우 예외 던짐
        for (CompareTest comp : list) {
            Objects.requireNonNull(comp);
            Objects.requireNonNull(comp.number);
        }
        Collections.sort(list);
    }

    class CompareTest implements Comparable<CompareTest> {
        Integer number;

        @Override
        public int compareTo(CompareTest o) {
            return Integer.compare(this.number, o.number);
        }
    }
}
