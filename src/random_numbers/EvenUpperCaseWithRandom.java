package random_numbers;

import java.util.*;

public class EvenUpperCaseWithRandom {
    public static String upperEvenLetters(String message) {
        // write your code here
        StringBuilder stringNew = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (i % 2 == 0) {
                stringNew.append(Character.toUpperCase(message.charAt(i)));
            } else {
                stringNew.append(message.charAt(i));

            }

        }
        return stringNew.toString();
    }
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
    static ArrayList<Character> removeDuplicate(StringBuilder input)
    {
        String string = input.toString();
        char[] array = string.toCharArray();
        Arrays.sort(array);
        ArrayList<Character> secretCode = new ArrayList<>();
        for (int i=0; i<array.length-1; i++){
            if (array[i] != array[i+1]){
                secretCode.add(array[i]);
            }
        }
        secretCode.add(array[array.length - 1]);
        return secretCode;
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
        if (length <= 36) {
            for (int i = 0; i < length; i++) {
                array.add(randomSecretCode.get(i));
            }
            for (int j = 0; j < length; j++) {
                strNew.append(array.get(j));
            }
        } else {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
        }
        return strNew;
    }

    // Don't change the code below
    public static void main(String[] args) {
        System.out.println("Input the length of the secret code:");
        Scanner scanner = new Scanner(System.in);
        //String message = scanner.nextLine();
        int length = scanner.nextInt();
        System.out.println("Input the number of possible symbols in the code:");
        int lengthOfPossibleSymbols = scanner.nextInt();
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
            //counter++;
            String input = scanner.next();
            int variableNew = Grader(input, variable);
            if (variableNew == length) {
                return;
            }
        }
    }
}
