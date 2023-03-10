package random_numbers;

import java.util.*;

public class EvenUpperCaseWithRandom {
    public static int Grader(String input, StringBuilder predefinedCode) {
        int counterBulls = 0;
        int counterCows = 0;
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
            if (counterCows != 1 && counterBulls != 1) {
                System.out.printf("Grade: %d bulls and %d cows%n", counterBulls, counterCows);
            } else if (counterCows !=1) {
                System.out.printf("Grade: %d bull and %d cows%n", counterBulls, counterCows);
            } else if (counterBulls != 1) {
                System.out.printf("Grade: %d bulls and %d cow%n", counterBulls, counterCows);
            } else {
                System.out.printf("Grade: %d bull and %d cow%n", counterBulls, counterCows);
            }
        } else if (counterBulls == input.length()) {
            System.out.printf("Grade: %d bulls%n", counterBulls);
            System.out.println("Congratulations! You guessed the secret code.");
        }else if (counterBulls == 0 && counterCows != 0) {
            if (counterCows == 1) {
                System.out.printf("Grade: %d cow%n", counterCows);
            } else {
                System.out.printf("Grade: %d cows%n", counterCows);
            }
        } else if (counterBulls != 0) {
            if (counterBulls == 1) {
                System.out.printf("Grade: %d bull%n", counterBulls);
            } else {
                System.out.printf("Grade: %d bulls%n", counterBulls);
            }
        } else {
            System.out.println("Grade: None");
        }

        return counterBulls;
    }
    public static StringBuilder SecretCodegenerator(int length, int lengthOfPossibleCharacters) {
        ArrayList<Character> secretCode = new ArrayList<>(List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                'w', 'x', 'y', 'z'));
        ArrayList<Character> randomSecretCode = new ArrayList<>();
        for (int i = 0; i < lengthOfPossibleCharacters; i++) {
            randomSecretCode.add(secretCode.get(i));
        }
        Collections.shuffle(randomSecretCode);
        ArrayList<Character> array = new ArrayList<>();
        StringBuilder strNew = new StringBuilder();

            for (int i = 0; i < length; i++) {
                array.add(randomSecretCode.get(i));
            }
            for (int j = 0; j < length; j++) {
                strNew.append(array.get(j));
            }

        return strNew;
    }

    // Don't change the code below
    public static void main(String[] args) {
        System.out.println("Input the length of the secret code:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            int length = Integer.parseInt(input);
            if (length == 0) {
                System.out.println("Error: you can not enter a code with length 0");
                return;
            }
            System.out.println("Input the number of possible symbols in the code:");
            int lengthOfPossibleSymbols = scanner.nextInt();
            if (lengthOfPossibleSymbols < length) {
                System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.", length, lengthOfPossibleSymbols);
                return;
            }
            if (lengthOfPossibleSymbols > 36) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                return;
            }
            if (lengthOfPossibleSymbols <= 10) {
                System.out.print("The secret is prepared: ");
                for (int i = 0; i < length; i++) {
                    System.out.print("*");
                }
                System.out.printf(" (0-%d).%n", lengthOfPossibleSymbols - 1);
            } else if (lengthOfPossibleSymbols == 11){
                System.out.print("The secret is prepared: ");
                for (int i = 0; i < length; i++) {
                    System.out.print("*");
                }
                System.out.println(" (0-9, a).");
            } else {
                char variable = (char)(lengthOfPossibleSymbols + 86);
                System.out.print("The secret is prepared: ");
                for (int i = 0; i < length; i++) {
                    System.out.print("*");
                }
                System.out.printf(" (0-9, a-%c).%n", variable);

            }
            StringBuilder variable = SecretCodegenerator(length, lengthOfPossibleSymbols);
            System.out.println("Okay, let's start a game!");
            int counter = 1;
            while (scanner.hasNextLine()) {
                System.out.printf("Turn %s:", counter++);
                System.out.println();
                String inputNew = scanner.next();
                int variableNew = Grader(inputNew, variable);
                if (variableNew == length) {
                    return;
                }
            }
        }catch (NumberFormatException ex) {
            System.out.printf("Error: \"%s\" isn't a valid number.", input);
        }
    }
}
