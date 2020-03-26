package ch20_enums;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author shishaolong
 * @datatime 2020/3/20 13:40
 */
public class test {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 59, 85);
        System.out.println(list.stream().allMatch(i -> i == 59));

        List<Integer> ll = Arrays.asList(4, 4, 3);
        System.out.println(ll.stream().allMatch(i -> i == 4));

        Integer integer = ll.stream().reduce((a, b) -> a + b).get();
        System.out.println(integer);

        BigDecimal bigDecimal = new BigDecimal(52.365);
        HashMap<String, Object> map = new HashMap<>();
        map.put("map", bigDecimal.doubleValue());
        System.out.println(map);
    }



}
