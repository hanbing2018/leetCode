深入理解JDK8

1、函数式接口

如果一个接口有且只有一个抽象方法，那么它就是一个**函数式接口**。

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

