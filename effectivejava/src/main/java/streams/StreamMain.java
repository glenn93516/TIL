package streams;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class StreamMain {
    public static void main(String[] args) {
        List<String> words = List.of("a", "bc", "dcfgf", "adgegseg", "asde");

        // 스트림을 과용 & 매개변수 이름이 모호한 케이스
        badCaseStream(words);

        // helper method 사용 & 매개변수 이름 명확히 써준 케이스
        /*
            helper method를 사용한 것과, 불필요한 stream을 제거한 것 만으로 가독성이 상당히 높아진다
            물론 여기에 람다의 매개변수 명을 보다 정확히 명시해 더 나아졌다
         */
        betterCaseStream(words);

        // 스트림 패러다임에 맞게 잘 사용하자
        // 단순히 스트림으로 바꾸기만 하면 스트림의 기능을 잘 활용하기 어려움
        notStreamParadigmCase();
        streamParadigm();
    }

    private static void betterCaseStream(final List<String> words) {
        words.stream().collect(groupingBy(word -> alphabetize(word)))
                .values().stream()
                .filter(group -> group.size() >= 1)
                .forEach(group -> System.out.println(group.size() + ": " + group));
    }

    private static String alphabetize(String word) {
        return word.chars().sorted()
                .collect(StringBuilder::new,
                        (sb, c) -> sb.append((char) c),
                        StringBuilder::append).toString();
    }

    private static void badCaseStream(final List<String> words) {
        words.stream().collect(
                        groupingBy(s -> s.chars().sorted()
                                .collect(StringBuilder::new,
                                        (sb, c) -> sb.append((char) c),
                                        StringBuilder::append).toString()))
                .values().stream()
                .filter(g -> g.size() >= 1)
                .map(g -> g.size() + ": " + g)
                .forEach(System.out::println);
    }

    private static void notStreamParadigmCase() {
        Map<String, Long> freq = new HashMap<>();
        // stream 은 사용했으나, 스트림처럼 보이는 반복문에 불과하다
        // stream에게 전달되는 freq의 상태가 변하는 side effect가 있기 때문
        List.of("a", "abc", "cdef", "z").forEach(word ->
                freq.merge(word.toLowerCase(), 1L, Long::sum));
        System.out.println(freq);
    }

    private static void streamParadigm() {
        Map<String, Long> freq = Stream.of("a", "abc", "cdef", "z")
                .collect(groupingBy(String::toLowerCase, counting()));
        System.out.println(freq);
    }
}
