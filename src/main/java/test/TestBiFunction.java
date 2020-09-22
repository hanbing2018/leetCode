package test;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author hanbing
 * @date 2020-01-05 19:49
 */
public class TestBiFunction {

    public int compute(int i, int j, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer, Integer> function) {
        return biFunction.andThen(function).apply(i, j);
    }


    public static void main(String[] args) {
        TestBiFunction test = new TestBiFunction();
        int ans = test.compute(2, 3, (x, y) -> x + y, value -> value * value);  //25
        System.out.println(ans);
    }
}
