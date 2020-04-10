package ch10_interfaces.adapters;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * @author shishaolong
 * @datatime 2020/4/10 14:24
 */
public class AdapterRandomDoubles implements RandomDoubles, Readable {

    private int count;

    public AdapterRandomDoubles(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count-- == 0) {
            return -1;
        }
        String result = Double.toString(next()) + " ";  // 关键适配  调用原接口方法，转成另一个接口方法所需要的参数
        cb.append(result);
        return result.length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new AdapterRandomDoubles(8));
        while (scanner.hasNextDouble()) {
            System.out.println(scanner.nextDouble() + "");
        }
    }
}
