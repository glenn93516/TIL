package streams;

import java.util.List;

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
}
