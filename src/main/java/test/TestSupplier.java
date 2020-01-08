package test;

import java.util.function.Supplier;

/**
 * @author hanbing
 * @create 2020-01-08 9:17
 */
public class TestSupplier {

    public static void main(String[] args) {

        Supplier<Integer> supplier = () -> 8;

        //通过函数引用创建函数式接口的实现类
        Supplier<String> supplier1 = String::new;
    }


}
