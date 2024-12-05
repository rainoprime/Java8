package one;

import java.io.File;
import java.io.FileFilter;
import java.util.function.Predicate;

/**
 * 筛选隐藏文件Java8和java8之前的代码进行对比
 *
 * @author Jason
 * @date 2024.12.5
 */
public class SiftHiddenFile {
    public static void main(String[] args) {
        // Java8 之前的写法
        File[] fileOld = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });
        // Java8的写法
        File[] fileNew = new File(".").listFiles(File::isHidden);
    }
}
