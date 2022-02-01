package methods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArgumentValidationTest {
    @Test
    void testAssert() {
        ArgumentValidation argumentValidation = new ArgumentValidation();

        assertThrowsExactly(AssertionError.class, () -> argumentValidation.assertTest(null));
        assertThrowsExactly(AssertionError.class, () -> argumentValidation.assertTest(-3));
        assertDoesNotThrow(() -> argumentValidation.assertTest(5));
    }
}