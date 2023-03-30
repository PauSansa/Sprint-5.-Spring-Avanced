package App;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entry {
    public static Scanner sc = new Scanner(System.in);

    public static byte askByteRange(String message, int minNumber, int maxNum){


        byte outputParameter = 0;
        boolean continua  = true;

        do {
            try {
                System.out.println("\r"+message);
                outputParameter = sc.nextByte();
                if(outputParameter > minNumber || outputParameter < maxNum) {
                    continua = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entered value isn't a byte, try again! ");
            }
            sc.nextLine();
        } while (continua);
        return outputParameter;
    }
}
