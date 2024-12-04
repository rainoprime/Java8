package one;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Java8的排序
 *
 * @author Jason
 * @date 2024.12.4
 */
public class Sort {

    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(900));
        inventory.add(new Apple(133));
        inventory.add(new Apple(599));

        // Java8使用流排序
        inventory.sort(Comparator.comparingInt(Apple::getWeight).reversed()); // 倒序
        inventory.sort(Comparator.comparingInt(Apple::getWeight)); // 正序

        // 老的写法
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return 0;
            }
        });

        for (Apple apple : inventory) {
            System.out.println(apple.getWeight());
        }
    }
}
class Apple {

    private Integer weight;

    public Apple(Integer weight) {
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
