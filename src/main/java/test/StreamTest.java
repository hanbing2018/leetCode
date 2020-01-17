package test;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
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

        //toArray方法，参数为IntFunction的实现类，会将stream的长度作为IntFunction的apply的参数，通过实现apply方法返回包含该stream所有元素的数组
        Object[] objects = list.stream().toArray(length -> new Object[length]);
        String[] strings1 = list.stream().toArray(String[]::new);

        //collect方法,Supplier<R> supplier创建容器确定返回值类型，BiConsumer<R, ? super T> accumulator取出stream中的每个元素进行操作（加入到容器中），BiConsumer<R, R> combiner对容器进行组合并返回值
        //实现Stream转换为list
        list.stream().collect(() -> new ArrayList<String>(), (theList, value) -> theList.add(value), (list1, list2) -> list1.addAll(list2));
        //实现Stream中所有字符串的拼接
        list.stream().collect(() -> new StringBuilder(),
                              (theStringBuilder, value) -> theStringBuilder.append(value),
                              (stringBuilder1, stringBuilder2) -> stringBuilder1.append(stringBuilder2)).toString();

    }
}
