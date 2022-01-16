package enumtype;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class EnumMapMain {
    public static void main(String[] args) {
        List<Plant> plants = new ArrayList<>();
        plants.add(new Plant("tree1", Plant.LifeCycle.ANNUAL));
        plants.add(new Plant("tree2", Plant.LifeCycle.BIENNIAL));
        plants.add(new Plant("tree3", Plant.LifeCycle.ANNUAL));

        // 1. Using array
        // LifeCycle 개수만큼 집합 생성
        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
        for(int i = 0; i < plantsByLifeCycle.length; i++) {
            plantsByLifeCycle[i] = new HashSet<>();
        }
        // 각 식물이 생애주기에 맞게 집합에 넣음
        for(Plant p : plants) {
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
        }
        // 출력 : 라벨링도 직접 해줘야함
        for(int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }

        // 2. Using EnumMap
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycleEnumMap = new EnumMap<>(Plant.LifeCycle.class);
        // LifeCycle 별로 집합 생성
        for(Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantsByLifeCycleEnumMap.put(lc, new HashSet<>());
        }
        // 각 식물의 생애주기에 맞게 집합에 넣어 줌
        for(Plant p : plants) {
            plantsByLifeCycleEnumMap.get(p.lifeCycle).add(p);
        }
        // 출력
        System.out.println(plantsByLifeCycleEnumMap);

        // 2.1. Using Stream
        // HashMap
        Map<Plant.LifeCycle, List<Plant>> collectHashMap = plants.stream()
                .collect(groupingBy(p -> p.lifeCycle));
        System.out.println(collectHashMap.getClass()); // groupingBy()를 이용할 경우 HashMap 구현체를 사용해 성능상 이점을 누리기 어렵다.
        System.out.println(collectHashMap);
        // EnumMap
        // groupingBy에게 Map 구현체를 전달하면 된다
        EnumMap<Plant.LifeCycle, Set<Plant>> collectEnumMap = plants.stream()
                .collect(groupingBy(p -> p.lifeCycle, () -> new EnumMap<>(Plant.LifeCycle.class), toSet()));
        System.out.println(collectEnumMap.getClass());
        System.out.println(collectEnumMap);
    }
}
