package lambda;

import java.util.function.Supplier;

public class OTPGeneration {

    public static void main(String[] args) {

        Supplier<String> otpSupplier = () -> {
            char[] chars = {'A','B','C','D','E'};
            char startChar = chars[(int) (Math.random() * 4)];
            long middleNumber = Math.round(Math.random()*(999 - 100) + 100);
            char endchar = chars[(int) (Math.random() * 4)];

            return ""+startChar+middleNumber+endchar;
        };

        System.out.println(otpSupplier.get());
        System.out.println(otpSupplier.get());
        System.out.println(otpSupplier.get());
        System.out.println(otpSupplier.get());
        System.out.println(otpSupplier.get());
        System.out.println(otpSupplier.get());
        System.out.println(otpSupplier.get());
        System.out.println(otpSupplier.get());
        System.out.println(otpSupplier.get());
        System.out.println(otpSupplier.get());
        System.out.println(otpSupplier.get());
        System.out.println(otpSupplier.get());
        System.out.println(otpSupplier.get());
        System.out.println(otpSupplier.get());

    }
}
