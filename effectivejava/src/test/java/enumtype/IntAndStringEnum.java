package enumtype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntAndStringEnum {
    // ORANGE int & String enum pattern
    public static String ORANGE_BREAD = "ORANGE_BREAD";
    public static int ORANGE_JUICE = 0;
    // APPLE int & String enum pattern
    public static String APPLE_BREAD = "APPLE_BREAD";
    public static int APPLE_JUICE = 0;

    // enum type
    enum Orange {
        BREAD,
        JUICE
    }
    enum Apple {
        BREAD("BREAD"),
        JUICE("JUICE");

        private final String value;

        Apple(String value) {
            this.value = value;
        }
    }

    @Test
    void 정수_열거타입은_접두어를_통해_이름_충돌을_방지해야_한다() {
        // 상수 이름을 통해서가 아니면 컴파일러는 두 값을 구분할 수 없다
        assertNotEquals(APPLE_JUICE, ORANGE_JUICE);
    }

    @Test
    void enum_type은_각자의_namespace가_있다() {
        // 상수명이 같아도 각자의 namespace가 있어 컴파일러가 구분할 수 있다
        assertNotEquals(Orange.BREAD, Apple.BREAD);
    }

    @Test
    void 하드코딩한_코드를_컴파일러는_구분할_수_없다() {
        // 하드코딩한 코드를 구분할 수 없기 때문에 오타가 발생해도 컴파일러가 확인할 수 없다
        assertNotEquals("APPLE_BREAD", APPLE_BREAD);
    }

    @Test
    void 하드코딩한_코드와_enum_type은_다르다() {
        assertNotEquals("JUICE", Apple.JUICE);
    }
}
