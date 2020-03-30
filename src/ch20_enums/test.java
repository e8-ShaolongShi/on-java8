package ch20_enums;

import java.util.HashMap;
import java.util.StringJoiner;

/**
 * @author shishaolong
 * @datatime 2020/3/20 13:40
 */
public class test {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 59, 85);
//        System.out.println(list.stream().allMatch(i -> i == 59));
//
//        List<Integer> ll = Arrays.asList(4, 4, 3);
//        System.out.println(ll.stream().allMatch(i -> i == 4));
//
//        Integer integer = ll.stream().reduce((a, b) -> a + b).get();
//        System.out.println(integer);
//
//        BigDecimal bigDecimal = new BigDecimal(52.365);
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("map", bigDecimal.doubleValue());

//        HashMap<String, Object> map = new HashMap<>();
//        map.put("long", 52);
//        map.put("long", 47);
//        System.out.println(map);

        HashMap<String, String> params = new HashMap<>();
        params.put("htlx", "5153"); // 合同类型
        params.put("djh", "15315"); // 单据号
        // OA 请求日志保存
        StringJoiner stringJoiner = new StringJoiner("&", "?", "");
        params.entrySet().forEach(entry -> {
            stringJoiner.add(entry.getKey() + "=" + entry.getValue());
        });
        System.out.println(stringJoiner.toString());
        ;
    }


}
