package JavaConcurrencyCookbook.chapter4;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class FactorialCalculator implements Callable<BigInteger> {
    private final Integer number;

    public FactorialCalculator(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public BigInteger call() {
        BigInteger result = BigInteger.ONE;

        if (number == 0 || number == 1) {
            result = BigInteger.ONE;
        } else {
            for (int i = number; i > 1; i--) {
                result = result.multiply(BigInteger.valueOf(i));
//                Thread.sleep(20);
            }
        }
//        System.out.printf("Factorial of %d is %d%n", number, result);
        return result;
    }
}
