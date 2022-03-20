package junior.programmers;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        System.out.println(new BigDecimal(20 * 0.1).setScale(0, BigDecimal.ROUND_DOWN).intValue());

        //System.out.println((20 - (payCutOff == 0 ? 0 : pay)));
    }
}
