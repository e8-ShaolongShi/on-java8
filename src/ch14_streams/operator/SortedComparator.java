package ch14_streams.operator;

import ch14_streams.create.FileToWordsBuilder;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * 流中元素排序
 * sorted(Comparator com)
 *
 * @Author 时少龙
 * @Date 2019-08-31 10:43
 * @Version 1.0
 */
public class SortedComparator {

    private static Stream stream() {
        Stream<String> stream = null;
        try {
            stream = new FileToWordsBuilder(new File("src/ch14_streams/create/Cheese.dat").getAbsoluteFile().toString())
                    .stream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream;
    }

    /**
     * 查看原始的流元素
     */
    private static void origin() {
        stream()
                .skip(10)
                .limit(10)
                .map(w -> w + " ")
                .forEach(System.out::print);
    }

    /**
     * 查看默认排序的流元素
     */
    private static void defaultSorted() {
        stream().skip(10).limit(10).sorted().map(w -> w + " ").forEach(System.out::print);
    }

    /**
     * 自定义排序
     */
    static void customSorted() {
        stream().skip(10).limit(10).sorted(Comparator.reverseOrder()).map(w -> w + " ").forEach(System.out::print);
        System.out.println("\n  自己实现比较方法");
        stream()
                .skip(10)
                .limit(10)
                .sorted(
                        (a, b) -> {
                            return Math.negateExact(((String) a).compareTo((String) b));
                        }
                )
                .map(w -> w + " ").forEach(System.out::print);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("1.查看原始值");
        origin();
        System.out.println("\n2.查看默认排序  默认排序即自然排序");
        defaultSorted();
        System.out.println("\n3.查看自定义排序");
        customSorted();
    }
}
