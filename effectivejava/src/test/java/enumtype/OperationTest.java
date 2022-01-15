package enumtype;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {
    @ParameterizedTest(name = "{0} {2} {1} = {3} 이어야 한다")
    @MethodSource("getOperations")
    void 연산자별로_다른_연산을_할_수_있다(double x, double y, Operation operation, double expected) {
        assertEquals(expected, operation.apply(x, y));
    }

    static Stream<Arguments> getOperations() {
        return Stream.of(
                Arguments.of(6.0, 2.0, Operation.PLUS, 8.0),
                Arguments.of(6.0, 2.0, Operation.MINUS, 4.0),
                Arguments.of(6.0, 2.0, Operation.DIVIDE, 3.0),
                Arguments.of(6.0, 2.0, Operation.TIMES, 12.0)
        );
    }
}