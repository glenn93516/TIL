package methods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseEmptyCollection {
    private static final List<String> strings = List.of("a", "b", "c");
    // 배열의 경우 이렇게 미리 길이 0인 배열을 만들어 사용하면 성능 저하가 없다
    private static final String[] EMPTY_ARRAY = new String[0];

    static List<String> getStringsWithNull() {
        // null 을 반환하려면 추가적인 작업이 필요함
        return strings.isEmpty() ? null : new ArrayList<>(strings);
    }

    static List<String> getStringsWithNonNull() {
        // 더 간결하고 null 체크 필요도 없어진다.
        return new ArrayList<>(strings);
        // 성능이 걱정되는 경우 Collections이 제공하는 불변객체를 활용하자
//        return Collections.emptyList();
    }

    public static void main(String[] args) {
        List<String> stringsWithNull = getStringsWithNull();
        if (stringsWithNull != null) {
            System.out.println("클라이언트에서 null인 케이스를 처리해줘야함");
        }

        // null 체크가 필요없다
        List<String> stringsWithNonNull = getStringsWithNonNull();
    }
}
