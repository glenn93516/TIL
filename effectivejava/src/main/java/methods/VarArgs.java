package methods;

public class VarArgs {
    // 최솟값을 찾는 메서드
    // 매개변수가 0개 받을 수도 있기 때문에 코드가 더러워지고 런타임 실패가 발생할 수 있음
    static int findMinBadCase(int... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("적어도 1개 이상의 인수가 필요합니다");
        }
        int min = args[0];
        // min을 초기화하지 않는다면 foreach 사용하기도 애매함
        for (int i = 1; i < args.length; i++) {
            if (args[i] < min) {
                min = args[i];
            }
        }
        return min;
    }

    static int findMinBetterCase(int first, int... remains) {
        // 매개변수 1개는 보장이 되기 때문에 exception 처리 필요없음
        int min = first;
        // 필수로 받는 매개변수를 초기값으로 설정하기 때문에 foreach 사용도 용이함
        for (int remain : remains) {
            if (remain < min) {
                min = remain;
            }
        }
        return min;
    }
}
