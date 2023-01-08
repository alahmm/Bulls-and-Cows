package bullscows;

import java.util.Scanner;

public class Main {
    public static void Grader(String input) {
        String predefinedCode = "9305";
        int counterBulls = 0;
        int counterCows = 0;
        if (predefinedCode.equals(input)) {
            System.out.printf("Grade: 4 bull(s). The secret code is %s.", predefinedCode);
        } else {
            for (int i = 0; i < predefinedCode.length(); i++) {
                for (int j = 0; j < input.length(); j++) {
                    char characterOld = predefinedCode.charAt(i);
                    char characterNew = input.charAt(j);
                    if (i == j) {
                        if (characterOld == characterNew) {
                            counterBulls++;
                        }
                    } else {
                        if (characterOld == characterNew) {
                            counterCows++;
                        }
                    }
                }
            }
            if (counterBulls != 0 && counterCows != 0) {
                System.out.printf("Grade: %d bull(s) and %d cow(s). The secret code is %s.", counterBulls, counterCows, predefinedCode);
            } else if (counterBulls == 0 && counterCows != 0) {
                System.out.printf("Grade: %d cow(s). The secret code is %s.", counterCows, predefinedCode);
            } else if (counterBulls != 0 && counterCows == 0) {
                System.out.printf("Grade: %d bull(s). The secret code is %s.", counterBulls, predefinedCode);
            } else {
                System.out.printf("Grade: None. The secret code is %s.", predefinedCode);
            }
        }

    }
    public static void main(String[] args) {
/*                String string = """
                The secret code is prepared: ****.

                Turn 1. Answer:
                1234
                Grade: None.

                Turn 2. Answer:
                9876
                Grade: 4 bulls.
                Congrats! The secret code is 9876.""";
        System.out.println(string);*/
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Grader(input);

    }
}
