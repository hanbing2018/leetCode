package test;

import java.util.Optional;
import java.util.function.Function;

/**
 * @author hanbing
 * @create 2020-01-09 17:03
 */
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
    }
}
