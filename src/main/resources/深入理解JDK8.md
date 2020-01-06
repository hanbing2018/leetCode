# java8新特性

1、函数式接口

如果一个接口只有一个抽象方法，那么它就是一个**函数式接口**。

@FunctionalInterface注解标注在接口上，则编译器就会按照函数式接口的定义来要求此接口。

无论有没有上述注解，满足函数式接口的定义的接口就会被编译器视为函数式接口。

如果函数式接口新增加一个抽象方法，如果这个抽象方法覆写了Object类的public方法，则它依然是一个函数式接口。

```java
@FunctionalInterface
interface myInterface{   //这是一个函数式接口！！
	void test();
	String toString();
}
```

**函数式接口中可以含有默认方法和静态方法**，不影响其函数式接口的定义，比如java.util.function.consumer。

```java
@FunctionalInterface
public interface Consumer<T> {

    void accept(T t);

    default Consumer<T> andThen(Consumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> { accept(t); after.accept(t); };
    }
}
```

2、lambda表达式

需要lambda表达式的原因：java语言的函数不能以函数作为参数和返回值，lambda的出现解决了者一问题。

lambda表达式为java提供了函数式编程的功能，必须依附于函数式接口，**实质上是函数式接口的实现对象**。

```java
//lambda表达式的形式
(参数列表)->{
//do something
}

//lambda使用的示例①
Consumer<Integer> consumer = integer -> System.out.println(integer);

//lambda使用的示例②
list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
});

//在功能上等同于
list.forEach(integer -> System.out.println(integer)); 
//integer没有声明类型是因为可以通过类型推断得出，故上述语句等价于
list.forEach((Integer integer) -> System.out.println(integer)); 

//lambda有几种可以简写的情况，略
```

补充：**方法引用**也可以创建函数式接口的实例(了解) 

```java
list.forEach(System.out::print);  //通过方法引用创建函数式接口的实例
```

3、函数式接口Function详解

```java
@FunctionalInterface
public interface Function<T, R> {

    R apply(T t);

    default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }

    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }
    
    static <T> Function<T, T> identity() {
        return t -> t;
    }
}
```

R apply(T t)定义的是主要操作，compose和andThen定义的是function中apply的执行顺序。如下的示例演示了两个函数的用法

```java
public class Test {


    public int compute1(int i, Function<Integer, Integer> function1, Function<Integer, Integer> function2){
        //先计算function2的apply，得到的结果作为function1的apply的参数进行第二次计算
        return function1.compose(function2).apply(i);
    }

    public int compute2(int i, Function<Integer, Integer> function1, Function<Integer, Integer> function2){
        return function1.andThen(function2).apply(i);
    }

    public static void main(String[] args) {
        Test test = new Test();
        int ans1 = test.compute1(2, value -> value * 3, value -> value * value); //12
        int ans2 = test.compute2(2, value -> value * 3, value -> value * value); //36
    }
}
```

4、函数式接口BiFunction详解

```java
@FunctionalInterface
public interface BiFunction<T, U, R> {

    R apply(T t, U u);

    default <V> BiFunction<T, U, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t, U u) -> after.apply(apply(t, u));
    }
}
```

和Function接口类似，apply方法接收两个参数，通过某种计算返回计算的值。**注意上述andThen的参数为Function，且没有compose函数，因为函数只能返回一个值！！**如下演示了apply和andThen的用法。

```java
public class TestBiFunction {

    public int compute(int i, int j, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer, Integer> function){
        //先执行biFunction的apply函数，得到的结果作为function的apply的参数进行第二次计算
        return biFunction.andThen(function).apply(i, j);
    }

    public static void main(String[] args) {
        TestBiFunction test = new TestBiFunction();
        int ans = test.compute(2, 3, (x, y) -> x + y, value -> value * value);
        System.out.println(ans);  //25
    }
}
```

5、函数式接口Predicate的介绍

```java
@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);

    default Predicate<T> and(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) && other.test(t);
    }

    default Predicate<T> negate() {
        return (t) -> !test(t);
    }

    static <T> Predicate<T> isEqual(Object targetRef) {
        return (null == targetRef)
                ? Objects::isNull
                : object -> targetRef.equals(object);
    }
}

```

6、高阶函数

如果一个函数接收一个函数作为参数，或者返回一个函数作为返回值，那么该函数就叫做高阶函数。高阶函数通常是指以函数式接口作为参数，或返回值类型为函数式接口的函数。