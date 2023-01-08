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
        return secretCode;
    }
    public static void SecretCodegenerator(int length) {
        long pseudoRandomNumber = System.nanoTime();
        StringBuilder str = new StringBuilder();
        str.append(pseudoRandomNumber).reverse();
        ArrayList<Character> secretCode = new ArrayList<>();
        secretCode = removeDuplicate(str);
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Character> arrayWithoutZero = new ArrayList<>();
        if (length == 1) {
            for (int i = 0; i < secretCode.toArray().length; i++) {
                if (secretCode.get(i) != '0') {
                    arrayWithoutZero.add(secretCode.get(i));
                }
            }
            for (int i = 0; i < length; i++) {
                array.add(Character.getNumericValue(arrayWithoutZero.get(i)));
            }
            StringBuilder strNew = new StringBuilder();
            for (int i = 0; i < length; i++) {
                strNew.append(array.get(i));
            }
            System.out.printf("The random secret number is %s.", strNew);
        } else if (length <= 10 && length > 1) {
            for (int i = 0; i < length; i++) {
                array.add(Character.getNumericValue(secretCode.get(i)));
            }

            while (array.get(0) == 0) {
                Collections.shuffle(array);
            }
            StringBuilder strNew = new StringBuilder();
            for (int i = 0; i < length; i++) {
                strNew.append(array.get(i));
            }
            System.out.printf("The random secret number is %s.", strNew);
        } else {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
        }

    }

    // Don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String message = scanner.nextLine();
        int length = scanner.nextInt();
        //RandomNumberCreator(length);
        SecretCodegenerator(length);
        //System.out.println(upperEvenLetters(message));
    }
}