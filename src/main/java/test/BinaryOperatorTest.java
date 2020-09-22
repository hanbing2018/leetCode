package test;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * @author hanbing
 * @create 2020-01-08 9:56
 */
public class BinaryOperatorTest {

    public static void main(String[] args) {
        BinaryOperatorTest test = new BinaryOperatorTest();
        test.method(23, 45, (value1, value2) -> value1 * value2);

        //静态函数minBy的使用
        //定义一个比较规则，此处字符长长度短的为“小”
        BinaryOperator<String> stringBinaryOperator = BinaryOperator.minBy((Comparator<String>) (o1, o2) -> o1.length() - o2.length());
        System.out.println(stringBinaryOperator.apply("sunwukong", "zhubajie"));


        System.out.println(test.minString("sunwukong", "tangseng", (o1, o2) -> o1.length() - o2.length()));
        System.out.println(test.minString("sunwukong", "tangseng", (o1, o2) -> o1.charAt(0) - o2.charAt(0)));
    }

    public int method(int a, int b, BinaryOperator<Integer> binaryOperator) {
        return binaryOperator.apply(a, b);
    }


    //定义一个比较函数，返回较小的字符串，比较规则在调用时传入
    public String minString(String s1, String s2, Comparator<String> comparator) {
        return BinaryOperator.minBy(comparator).apply(s1, s2);
    }
}
