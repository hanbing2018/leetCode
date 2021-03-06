# java8新特性

#### 1、函数式接口

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

#### 2、lambda表达式

需要lambda表达式的原因：java语言的函数不能以函数作为参数和返回值，lambda的出现解决了这一问题。

lambda表达式为java提供了函数式编程的功能，必须依附于函数式接口，**实质上是函数式接口的实现对象**。

```java
//lambda表达式的形式
(参数列表)->{
//do something
}

//lambda使用的示例1
Consumer<Integer> consumer = integer -> System.out.println(integer);

//lambda使用的示例2
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

//lambda有几种可以通过上下文简写的情况，略
```

高阶函数：如果一个函数接收一个函数作为参数，或者返回一个函数作为返回值，那么该函数就叫做高阶函数。高阶函数通常是指以函数式接口作为参数，或返回值类型为函数式接口的函数。

#### 3、外部迭代与内部迭代

通过外部的迭代器依次对元素进行访问是外部迭代，如list的for循环

```java
for(int i=0; i<list.size(); i++){
    //do something
}
```

直接通过容器自带的迭代函数依次访问元素是外部迭代，如list的forEach()函数

```java
List<Integer> list = new List<>();
list.forEach(i -> System.out.println(i));
```

高阶函数：如果一个函数接收一个函数作为参数，或者返回一个函数作为返回值，那么该函数就叫做高阶函数。java中高阶函数通常是指以函数式接口作为参数，或返回值类型为函数式接口的函数。

#### 4、函数式接口Function详解
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

#### 5、函数式接口BiFunction详解

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

BinaryOperator继承了BiFunction

```java
@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T,T,T> {

    public static <T> BinaryOperator<T> minBy(Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator);
        return (a, b) -> comparator.compare(a, b) <= 0 ? a : b;
    }

    public static <T> BinaryOperator<T> maxBy(Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator);
        return (a, b) -> comparator.compare(a, b) >= 0 ? a : b;
    }
}

//用法示例
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

    public int method(int a, int b, BinaryOperator<Integer> binaryOperator){
        return binaryOperator.apply(a, b);
    }


    //定义一个比较函数，返回较小的字符串，比较规则在调用时传入
    public String minString(String s1, String s2, Comparator<String> comparator){
        return BinaryOperator.minBy(comparator).apply(s1, s2);
    }
}


```

#### 6、函数式接口Predicate的介绍

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
    
    default Predicate<T> or(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) || other.test(t);
    }

    static <T> Predicate<T> isEqual(Object targetRef) {
        return (null == targetRef)
                ? Objects::isNull
                : object -> targetRef.equals(object);
    }
}

```

Predicate(中文翻译为谓语)接口的用法举例，筛选一个list中的数据。在事先不知道筛选规则的情况下可以利用此接口创建一个通用的函数，在具体调用的时候传入筛选的规则。

```java
public class TestPredicate {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9 , 10);
        TestPredicate testPredicate = new TestPredicate();
        //基本使用
        testPredicate.conditionFilter(list, value -> value%2 ==0);
        System.out.println("=======================");
        testPredicate.conditionFilter(list, value -> value > 4);
        System.out.println("==========================");

        //and函数的使用
        testPredicate.conditionFilterAnd(list, value -> value > 5, value -> value%2 == 0);
        System.out.println("==========================");

        //negate函数的使用
        testPredicate.conditionFilterNegate(list, value -> value > 5, value -> value%2 == 0);  //1,2,3,4,5,7,9
        System.out.println("==========================");

        //静态方法isEqusl的使用
        System.out.println(Predicate.isEqual("test").test("test"));


    }


    public void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer integer : list) {
            if( predicate.test(integer)){
                System.out.println(integer);
            }
        }
    }

    public void conditionFilterAnd(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2) {
        for (Integer integer : list) {
            if(predicate1.and(predicate2).test(integer)){   //添加两个谓词接口，只有两个test的函数都为true才执行代码
                System.out.println(integer);
            }
        }
    }

    public void conditionFilterNegate(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2) {
        for (Integer integer : list) {
            if(predicate1.and(predicate2).negate().test(integer)){   //添加两个谓词接口，判断条件是两个接口的条件"与"操作，再取反
                System.out.println(integer);
            }
        }
    }
    
}

```

#### 7、函数式接口Supplier介绍

```java
@FunctionalInterface
public interface Supplier<T> {

    T get();
}

public class TestSupplier {

    public static void main(String[] args) {

        Supplier<Integer> supplier = () -> 8;
        
        //通过函数引用创建函数式接口的实现类
        Supplier<String> supplier1 = String::new; 
    }
}
```

#### 8、Operational详解

Operational是jdk1.8新增的一个final类，同时也指的是解决NonePointException异常的方式。

```java
public final class Optional<T> {
    private static final Optional<?> EMPTY = new Optional<>();
    private final T value;

    private Optional() {
        this.value = null;
    }

    public static<T> Optional<T> empty() {
        @SuppressWarnings("unchecked")
        Optional<T> t = (Optional<T>) EMPTY;
        return t;
    }

    private Optional(T value) {
        this.value = Objects.requireNonNull(value);
    }

    public static <T> Optional<T> of(T value) {
        return new Optional<>(value);
    }

    public static <T> Optional<T> ofNullable(T value) {
        return value == null ? empty() : of(value);
    }

    public T get() {
        if (value == null) {
            throw new NoSuchElementException("No value present");
        }
        return value;
    }

    public boolean isPresent() {
        return value != null;
    }

    public void ifPresent(Consumer<? super T> consumer) {
        if (value != null)
            consumer.accept(value);
    }

    public Optional<T> filter(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        if (!isPresent())
            return this;
        else
            return predicate.test(value) ? this : empty();
    }

    public<U> Optional<U> map(Function<? super T, ? extends U> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent())
            return empty();
        else {
            return Optional.ofNullable(mapper.apply(value));
        }
    }

    public<U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent())
            return empty();
        else {
            return Objects.requireNonNull(mapper.apply(value));
        }
    }

    public T orElse(T other) {
        return value != null ? value : other;
    }

    public T orElseGet(Supplier<? extends T> other) {
        return value != null ? value : other.get();
    }

    public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        if (value != null) {
            return value;
        } else {
            throw exceptionSupplier.get();
        }
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Optional)) {
            return false;
        }

        Optional<?> other = (Optional<?>) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return value != null
            ? String.format("Optional[%s]", value)
            : "Optional.empty";
    }
}
```

Operational是一个**基于值的类**（value-based class）。基于值的类有以下特征：

- 是final的且不可变的，内部可以包含指向可变对象的引用。
- equals、hashCode、toString三个方法的结果完全取决于实例本身。
- 不会使用身份敏感的操作，例如(==)。
- 仅仅是基于equals方法的值决定是否相等，而不是通过==操作。
- 没有可访问的构造方法（即构造方法都是私有的），创建实例是通过工厂模式创建，并不保证创建实例的一致性。
- 如果两个对象equals返回true，那么这两个对象可任意交换。

Operational本质上是一个容器，包含一个final值value。

```java
public class TestOperational {
    public static void main(String[] args) {
        String str = "iiii";
//        String str = null;
        Optional<String> optional = Optional.ofNullable(str);

        optional.orElse("isEmpty");  //此函数作用为如果value为null，指定一个替代值
        optional.ifPresent((value) -> System.out.println(value));

        //optional更推荐的用法，也是其常用的用法
        Person person = new Person();
//        person.setName("sunwukong");
        Optional<Person> optional1 = Optional.of(person);
        System.out.println(optional1.map(thePerson -> thePerson.getName())
                                     .orElse("noName"));
        
        //注意事项，不要将Optional作为参数或成员变量，因为这不是它的最佳实践!!!
    }
}
```

#### 9、方法引用详解

method reference**是lambda表达式的语法糖**，是lambda表达式的特殊情况。可以把方法引用看做是函数指针(function pointer)。

方法引用分为4类：

- 类名::静态方法名

```java
public class MethodReferenceDemo {

    static int comExample(Person p1, Person p2){
        return -9;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");

        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        list.forEach(s -> System.out.println(s));

        list.forEach(System.out::println);
        System.out.println("===================================");
        Person p1 = new Person("sunwukong", 1255);
        Person p2 = new Person("zhubajie", 108);
        List<Person> persons = Arrays.asList(p1, p2);

        //list的sort函数需要传入一个Comparator接口,其抽象方法返回值为int，参数为两个Person对象，满足这些条件的静态函数都可以用函数式引用来表示
        
/*        persons.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });*/
        persons.sort(Person::compareByName);
        persons.forEach(person -> System.out.println(person.getName()));

        persons.sort(Person::compareByAge);
        persons.forEach(person -> System.out.println(person.getAge()));

        persons.sort(MethodReferenceDemo::comExample);
    }
}

```

- 引用名(对象名)::实例方法名

  在Person中增加两个方法

```java
    public int compareByNameNoStatic(Person p1, Person p2){
        return p1.name.compareTo(p2.name);
    }
    public int compareByAgeNoStatic(Person p1, Person p2){
        return p1.age - p2.age;
    }

```

​	则上述中的persons的排序可以写成如下的形式

```
        //对象名::实例方法名
        Person p = new Person();
        persons.sort(p::compareByNameNoStatic);
        persons.sort(p::compareByAgeNoStatic);
```

- 类名::实例方法名

Person类中增加两个实例方法

```java
//实例方法
    public int comByName(Person person){
        return this.name.compareTo(person.getName());
    }

    public int comByAge(Person person){
        return this.age - person.getAge();
    }
```

main中的调用方式为

```java
//sort接收一个comporator参数，以下写法，会将comByName的调用者作为lambda表达式的第一个参数，comByName的参数作为lambda的其他参数
persons.sort(Person::comByName);
persons.sort(Person::comByAge);
```

- 类名::new    ----引用类的构造方法

```java
    //Person类中构造方法的引用
    public String getString(Supplier<String> supplier){
        return supplier.get() + "test";
    }
    public String getString2(String str, Function<String, String> function){
        return function.apply(str);
```

main函数中调用上述方法

```java
//构造方法引用
p.getString(String::new);  //自动匹配String的无参构造方法,因为getString函数的参数实际上是需要一个返回值为String的无参的函数
p.getString2("hello", String::new); //自动匹配String的参数为一个字符串的构造方法
```

#### 10、接口的默认方法

多个接口中有同名的默认方法，且不能构成重载。当类同时实现多个这样的接口时，必须重写这个方法。

```java
public interface DefaultInterface1 {
    default void method(){}
}
public interface DefaultInterface2 {
    default void method(){}
}

```

```java
public class DefaultInterfaceImpl implements DefaultInterface1, DefaultInterface2 {

    @Override
    public void method() {
        //do something
        
        //重写method函数，也可以使用  接口名.supper.method()的方式 使用已经定义的默认方法
//        DefaultInterface1.super.method();
    }
}
```

```java
public class myClass extends DefaultInterfaceImpl implements DefaultInterface2 {
	//在这种情况下调用myClass的method方法会使用DefaultInterfaceImpl中的方法，因为java约定类中的方法比接口中的同名方法优先级高
}
```

#### 11、流

Stream流的介绍和使用，Stream流狭义上是jkd8的一个接口，广义上是java连续处理数据的一种方式。

**流由三部分组成：源、0个或多个中间操作、终止操作。**

**流操作的分类：1惰性求值，2及早求值。**

- 流的创建

```java
Stream stream = Stream.of("sunwukong", "zhbajie", "tangseng");

String[] strs = new String[]{"sunwukong", "zhbajie", "tangseng"};
Stream stream2 = Stream.of(strs);
Stream stream3 = Arrays.stream(strs);

List<String> list = Arrays.asList("sunwkong", "zhubajie", "tangseng");
Stream<String> stream4 = list.stream();
```

- 流的使用举例

```java
IntStream.range(1, 10).forEach(System.out::println);
IntStream.rangeClosed(1, 10).forEach(System.out::println);
int sum = intStream.map(i -> i*2).reduce(0, Integer::sum);  //求stream中所有int元素的和
```

Collection提供了stream()会生成流，**流不存储值，而是通过管道获取值。流的本质是函数式的，对流的操作会生成一个结果，但是不会修改底层数据源。集合可以作为流的底层数据源。**流的toArray方法会返回流泛型类型的数组

```java
List<String> list = Arrays.asList("sunwkong", "zhubajie", "tangseng");
//toArray方法，参数为IntFunction的实现类，会将stream的长度作为IntFunction的apply的参数，通过实现apply方法返回包含该stream所有元素的数组
Object[] objects = list.stream().toArray(length -> new Object[length]);//必须是stream中泛型的类型或其父类
String[] strings1 = list.stream().toArray(String[]::new);
```

Stream的collect方法详解

```java
/*
<R> R collect(Supplier<R> supplier,
                  BiConsumer<R, ? super T> accumulator,
                  BiConsumer<R, R> combiner);
*/
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
```

Stream中的map方法和flatMap方法也是很重要的方法，通过对stream中每一个元素进行映射实现对流中的各个元素相同的操作

```java
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

//Stream.generate() 静态方法，生成流的一种方式
Stream<String> generate = Stream.generate(() -> "something");
generate.findFirst().ifPresent(System.out::println);
//Stream.iterate() 静态方法，通过种子生成一个无限的串行流(?)，必须配合limit()使用
Stream.iterate(1, item -> item+2).limit(6).forEach(System.out::println);
```

```java
//Stream综合应用案例：Stream.iterate(1, item -> item+2).limit(6)，找出流中大于2的元素，然后乘以2，忽略前两个元素，
//再取前两个元素，再求和
System.out.println(Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).sum());
//IntStream的summaryStatistics()函数可以方便得得到需要的结果
IntSummaryStatistics intSummaryStatistics = 
    Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 2)
    .mapToInt(item -> item * 2).skip(2).limit(2).summaryStatistics();
intSummaryStatistics.getAverage();
intSummaryStatistics.getCount();
intSummaryStatistics.getSum();
intSummaryStatistics.getMax();
```

```java
//流只能使用一次，不可重复使用，以下代码会报错
Stream<Integer> streamInteger = Stream.of(1, 2, 3);
streamInteger.filter(item -> item>2); //流使用了一次，生成了新的流
//streamInteger.distinct();  //错误使用！！！流不能被重复使用
```