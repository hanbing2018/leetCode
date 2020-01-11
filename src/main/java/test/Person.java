package test;

/**
 * @author hanbing
 * @create 2020-01-10 12:33
 */
public class Person {
    private String name;
    private Integer age;


    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    static int compareByName(Person p1, Person p2){
        return p1.name.compareTo(p2.name);
    }

    static int compareByAge(Person p1, Person p2){
        return p1.age - p2.age;
    }

    public int compareByNameNoStatic(Person p1, Person p2){
        return p1.name.compareTo(p2.name);
    }
    public int compareByAgeNoStatic(Person p1, Person p2){
        return p1.age - p2.age;
    }

}
