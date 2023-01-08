package stringbuilder;

import java.util.*;

class EvenUpperCase {

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
            if (counterBulls != 0 && counterCows != 0 && counterBulls != 4) {
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
    public static StringBuilder SecretCodegenerator(int length) {
        //long pseudoRandomNumber = System.nanoTime();
        ArrayList<Integer> pseudoRandomNumber = new ArrayList<>(List.of(0,9,8,9,7,6,3,3,5,4,4,2,1));
        StringBuilder str = new StringBuilder();
        for (Integer variable : pseudoRandomNumber
             ) {
            str.append(variable);
        }
        str.reverse();
        ArrayList<Character> secretCode = new ArrayList<>();
        secretCode = removeDuplicate(str);
        ArrayList<Integer> array = new ArrayList<>();
        StringBuilder strNew = new StringBuilder();
        if (length == 1) {
            ArrayList<Character> arrayWithoutZero = new ArrayList<>();
            for (int i = 0; i < secretCode.toArray().length; i++) {
                if (secretCode.get(i) != '0') {
                    arrayWithoutZero.add(secretCode.get(i));
                }
            }
            for (int i = 0; i < length; i++) {
                array.add(Character.getNumericValue(arrayWithoutZero.get(i)));
            }
            //StringBuilder strNew = new StringBuilder();
            for (int j = 0; j < length; j++) {
                strNew.append(array.get(j));
            }
            //System.out.printf("The random secret number is %s.", strNew);
        } else if (length <= 10 && length > 1) {
            for (int i = 0; i < length; i++) {
                array.add(Character.getNumericValue(secretCode.get(i)));
            }

            while (array.get(0) == 0) {
                Collections.shuffle(array);
            }
            //StringBuilder strNew = new StringBuilder();
            for (int j = 0; j < length; j++) {
                strNew.append(array.get(j));
            }
            //System.out.printf("The random secret number is %s.", strNew);
        } else {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
        }
        return strNew;
    }

    // Don't change the code below
    public static void main(String[] args) {
        System.out.println("Please, enter the secret code's length:");
        Scanner scanner = new Scanner(System.in);
        //String message = scanner.nextLine();
        int length = scanner.nextInt();
        StringBuilder variable = SecretCodegenerator(length);
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

        //System.out.println(upperEvenLetters(message));
    }
}