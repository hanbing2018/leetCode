package test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author hanbing
 * @create 2020-01-07 18:05
 */
public class TestPredicate {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        TestPredicate testPredicate = new TestPredicate();
        //基本使用
        testPredicate.conditionFilter(list, value -> value % 2 == 0);
        System.out.println("=======================");
        testPredicate.conditionFilter(list, value -> value > 4);
        System.out.println("==========================");

        //and函数的使用
        testPredicate.conditionFilterAnd(list, value -> value > 5, value -> value % 2 == 0);
        System.out.println("==========================");

        //negate函数的使用
        testPredicate.conditionFilterNegate(list, value -> value > 5, value -> value % 2 == 0);  //1,2,3,4,5,7,9
        System.out.println("==========================");

        //静态方法isEqusl的使用
        System.out.println(Predicate.isEqual("test").test("test"));


    }


    public void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer integer : list) {
            if (predicate.test(integer)) {
                System.out.println(integer);
            }
        }
    }

    public void conditionFilterAnd(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2) {
        for (Integer integer : list) {
            if (predicate1.and(predicate2).test(integer)) {   //添加两个谓词接口，只有两个test的函数都为true才执行代码
                System.out.println(integer);
            }
        }
    }

    public void conditionFilterNegate(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2) {
        for (Integer integer : list) {
            if (predicate1.and(predicate2).negate().test(integer)) {   //添加两个谓词接口，判断条件是两个接口的条件"与"操作，再取反
                System.out.println(integer);
            }
        }
    }

}


