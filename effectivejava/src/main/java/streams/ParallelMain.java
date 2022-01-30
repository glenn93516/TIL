package streams;

import java.math.BigInteger;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

public class ParallelMain {
    public static void main(String[] args) {
        badParallelStream();
        usefulParallelStream(10);
    }

    static void badParallelStream() {
        primes().map(prime -> TWO.pow(prime.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);
    }

    static Stream<BigInteger> primes() {
        // 데이터 소스가 Stream.iterate일 경우 파이프라인 병렬화로 성능 개선을 할 수 없다
        // 병렬화의 이점을 누리려면 spliterator 메서드를 반드시 재정의 해야 한다
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }

    static long usefulParallelStream(int n) {
        return LongStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }
}
