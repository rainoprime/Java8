package one.behaviorParameterization;

import java.util.ArrayList;
import java.util.List;

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
        // Java8就可以使用Lambda实现的方式
        List<People> people1 = BehaviorParameterizationNew.selectPage(peoples, people -> people.getAge() >= 50);

        for (People people : people1) {
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
}
