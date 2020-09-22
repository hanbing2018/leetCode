package test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author hanbing
 * @date 2020-01-11 4:53
 */
public class MethodReferenceDemo {

    static int comExample(Person p1, Person p2) {
        return -9;
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");

        //三种等价的写法
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

        //list的sort函数需要传入一个Comparator接口,其抽象方法返回值为int，参数为两个Person对象，满足这些条件的静态函数
        //都可以用函数式引用来表示

/*        persons.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });*/

        //类名::静态方法名
        persons.sort(Person::compareByName);
        persons.forEach(person -> System.out.println(person.getName()));

        persons.sort(Person::compareByAge);
        persons.forEach(person -> System.out.println(person.getAge()));

        persons.sort(MethodReferenceDemo::comExample);
        System.out.println("===================================");

        //对象名::实例方法名
        Person p = new Person();
        persons.sort(p::compareByNameNoStatic);
        persons.sort(p::compareByAgeNoStatic);
        System.out.println("===================================");

        //类名::实例方法名
        persons.sort(Person::comByName);
        persons.sort(Person::comByAge);

        //构造方法引用
        p.getString(String::new);  //自动匹配String的无参构造方法
        p.getString2("hello", String::new); //自动匹配String的参数为一个字符串的构造方法
    }
}
