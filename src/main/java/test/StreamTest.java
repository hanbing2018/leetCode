package test;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author hanbing
 * @create 2020-01-16 11:24
 */
public class StreamTest {
    public static void main(String[] args) {
        Stream stream = Stream.of("sunwukong", "zhbajie", "tangseng");

        String[] strs = new String[]{"sunwukong", "zhbajie", "tangseng"};
        Stream stream2 = Stream.of(strs);
        Stream stream3 = Arrays.stream(strs);

        List<String> list = Arrays.asList("sunwkong", "zhubajie", "tangseng");
        Stream<String> stream4 = list.stream();

        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        intStream.forEach(System.out::println);
        System.out.println("=================");

        IntStream.range(1, 10).forEach(System.out::println);
        IntStream.rangeClosed(1, 10).forEach(System.out::println);

    }
}
