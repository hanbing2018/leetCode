package test;

import javax.print.DocFlavor;
import java.time.temporal.ValueRange;
import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
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
        Object[] objects = list.stream().toArray(length -> new Object[length]);  //必须是stream中泛型的类型或其父类
        String[] strings1 = list.stream().toArray(String[]::new);

        //collect方法,Supplier<R> supplier创建容器确定返回值类型，BiConsumer<R, ? super T> accumulator取出stream中的每个元素进行操作（加入到容器中），BiConsumer<R, R> combiner对容器进行组合并返回值
        //实现Stream转换为list
        list.stream().collect(() -> new ArrayList<String>(), (theList, value) -> theList.add(value), (list1, list2) -> list1.addAll(list2));
        //实现Stream中所有字符串的拼接
        list.stream().collect(() -> new StringBuilder(),
                              (theStringBuilder, value) -> theStringBuilder.append(value),
                              (stringBuilder1, stringBuilder2) -> stringBuilder1.append(stringBuilder2)).toString();

        //collect()另几种重载的方法
//        <R, A> R collect(Collector<? super T, A, R> collector);
        list.stream().collect(Collectors.toList());
        list.stream().collect(Collectors.toSet());
        list.stream().collect(Collectors.toCollection(HashSet::new));

        //其他重载方法,了解
        //参数为Collectors.joining()，效果为list中的字符进行拼接
        Collector<CharSequence, ?, String> joining = Collectors.joining();
        list.stream().collect(joining);

        String collect = list.stream().collect(Collectors.joining());

        //stream的map方法可以对stream中每个元素进行映射
        //<R> Stream<R> map(Function<? super T, ? extends R> mapper);
        //以下的语句实现将Stream<String>中的每个元素转换为大写，通过collect转换成List后依次打印输出
        list.stream().map(value -> value.toUpperCase()).collect(Collectors.toList()).forEach(value -> System.out.println(value));
        //上诉语句的等价写法
        list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);

        //还有一个flatmap函数(扁平化映射)
        Stream<List<Integer>> streamListInt = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
        //flatMap会将stream中的每一个list元素中的Integer元素取出进行映射，将每个list元素转换成流，再将每个流"组合"成为一个新的流
        streamListInt.flatMap(theList -> theList.stream()).collect(Collectors.toList()).forEach(System.out::println);
     }
}
