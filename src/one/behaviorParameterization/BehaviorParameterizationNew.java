package one.behaviorParameterization;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 行为参数化之后的代码
 *
 * @author Jason
 * @date 2024.11.4
 *
 */
public class BehaviorParameterizationNew {

    public static void main(String[] args) {
        List<People> peoples = new ArrayList<>();
        peoples.add(new People("Jason", 20));
        peoples.add(new People("Tom", 50));


        // Java8之前可以使用匿名内部类实现
        BehaviorParameterizationNew.selectPage(peoples, new BehaviorParameterizationInterface() {
            @Override
            public boolean selectPage(People people) {
               return people.getAge() > 50;
            }
        });
        // Java8就可以使用Lambda实现的方式，而33行就是对Lambda的简化
        List<People> people1 = BehaviorParameterizationNew.selectPage(peoples, people -> people.getAge() >= 50);

        // 这行代码 完全等价于 下面的匿名内部类，  行为参数化
        List<People> people2 = selectPageNew(peoples, People::isOld);

        // 该匿名内部类 完全等价于上面的方法引用
        BehaviorParameterizationInterface behaviorParameterizationInterface = new BehaviorParameterizationInterface() {
            @Override
            public boolean selectPage(People people) {
                return People.isOld(people);
            }
        };
        for (People people : people1) {
            System.out.println(people.getAge());
        }

        for (People people : people2) {
            System.out.println(people.getAge());
        }
    }

    public static List<People> selectPage(List<People> peoples, BehaviorParameterizationInterface behaviorParameterizationInterface) {
        List<People> result = new ArrayList<>();

        for (People people : peoples) {
            if (behaviorParameterizationInterface.selectPage(people)) {
                result.add(people);
            }
        }
        return result;

    }


    public static List<People> selectPageNew(List<People> peoples, Predicate<People> predicate) {
        List<People> result = new ArrayList<>();

        for (People people : peoples) {
            if (predicate.test(people)) {
                result.add(people);
            }
        }
        return result;

    }
}
