package one.behaviorParameterization;

import java.util.ArrayList;
import java.util.List;

/**
 * 行为参数化之前的代码
 *
 * @author Jason
 * @date 2024.12.4
 */
public class BehaviorParameterizationOld {

    public static void main(String[] args) {
        List<People> peopleList = new ArrayList<>();
        peopleList.add(new People("John", 18));
        peopleList.add(new People("Jason", 90));

        List<People> people = BehaviorParameterizationOld.selectPage(peopleList, 50);

        for (People person : people) {
            System.out.println(person.getAge());
        }
    }

    public static List<People> selectPage(List<People> peopleList, int age) {
        List<People> newPeopleList = new ArrayList<>();

        for (People people : peopleList) {
            if (people.getAge() >= age) {
                newPeopleList.add(people);
            }
        }

        return newPeopleList;
    }
}
class People {
    private String name;
    private Integer age;

    public People(String name, Integer age) {
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
    public static boolean isOld(People people) {
        return people.getAge() > 50;
    }
}