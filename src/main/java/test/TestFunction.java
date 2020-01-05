package test;

import java.util.function.Function;

/**
 * @author hanbing
 * @date 2020-01-04 11:23
 */
public class TestFunction {


    public int compute1(int i, Function<Integer, Integer> function1, Function<Integer, Integer> function2){
        return function1.compose(function2).apply(i);
    }

    public int compute2(int i, Function<Integer, Integer> function1, Function<Integer, Integer> function2){
        return function1.andThen(function2).apply(i);
    }

    public static void main(String[] args) {
        TestFunction test = new TestFunction();
        int ans1 = test.compute1(2, value -> value * 3, value -> value * value);  //12
        int ans2 = test.compute2(2, value -> value * 3, value -> value * value);  //36
    }
}
