package ProceduralurCalculator;

import java.util.Scanner;

//135 lines
public class Calculator {
    public static void main(String[] args) {
        // initialize scanner object
        Scanner scn = new Scanner(System.in);

        // Command Line interface
        System.out.println("Binary/Hexadecimal Calculator");
        System.out.println("If you want to perform Binary calculation enter 1, for Hex enter 2.");
        System.out.println("Or, you also have the option to convert binary or hex to decimal for this option enter 3.\nEnter: ");
        int calc = scn.nextInt();

        // Logic for type/operation selection
        if(calc == 1) {
            // Command Line Interface
            System.out.println("Chose an operation, 1: addition, 2: subtraction, 3: Division, 4: Multiplication" + "\nEnter: ");
            int op = scn.nextInt();
            System.out.println("Enter two Binary values\nValue 1: \nValue 2: ");
            String w = scn.nextLine(); // no idea why???
            String num1 = scn.nextLine();
            String num2 = scn.nextLine();

            // Cases relate to binary operations (add, subtract, divide, multiply)
            switch (op) {
                case 1 -> System.out.println(toBinary(Add(binaryToDecimal(num1), binaryToDecimal(num2))));
                case 2 -> System.out.println(toBinary(Subtract(binaryToDecimal(num1), binaryToDecimal(num2))));
                case 3 -> System.out.println(toBinary(Division(binaryToDecimal(num1), binaryToDecimal(num2))));
                case 4 -> System.out.println(toBinary(Multiply(binaryToDecimal(num1), binaryToDecimal(num2))));
                default -> System.out.println("Oops! Didn't pick an operation.");
            }
        } else if (calc == 2) {
            // Command Line interface
            System.out.println("Chose an operation, 1: addition, 2: subtraction, 3: Division, 4: Multiplication" + "\nEnter: ");
            int op = scn.nextInt();
            System.out.println("Enter two Hex values\nValue 1: \nValue 2: ");
            String w = scn.nextLine(); // no idea why???
            String num1 = scn.nextLine();
            String num2 = scn.nextLine();

            // Cases relate to hex operations (add, subtract, divide, multiply)
            switch (op) {
                case 1 -> System.out.println(toHex(Add(binaryToDecimal(num1), binaryToDecimal(num2))));
                case 2 -> System.out.println(toHex(Subtract(binaryToDecimal(num1), binaryToDecimal(num2))));
                case 3 -> System.out.println(toHex(Division(binaryToDecimal(num1), binaryToDecimal(num2))));
                case 4 -> System.out.println(toHex(Multiply(binaryToDecimal(num1), binaryToDecimal(num2))));
                default -> System.out.println("Oops! Didn't pick an operation.");
            }
        } else {
            // Command Line Interface
            System.out.println("Binary to decimal enter: 1\nDecimal to Binary enter: 2\nHex to decimal enter: 3\nDecimal to hex enter: 4\nEnter:");
            int conType = scn.nextInt();

            if (conType == 1 || conType == 3) {
                System.out.println("Enter value to be converted:");
                int value = scn.nextInt();

                // Converts decimal values to hex/binary
                switch (conType) {
                    case 1 -> System.out.println(toBinary(value));
                    case 3 -> System.out.println(toHex(value));
                }
            } else {
                System.out.println("Enter value to be converted:");
                String value = scn.nextLine();

                // Converts hex/binary values into decimal values
                switch (conType) {
                    case 2 -> System.out.println(binaryToDecimal(value));
                    case 4 -> System.out.println(hexToDecimal(value));
                }
            }
        }
    }


    public static String toBinary(int n) {
        int[] binaryAr = new int[1000];
        int i = 0;
        while(n > 0) {
            binaryAr[i] = n % 2; // Sets value to 1 or 0 based on remainder
           n /= 2; // set new value of n
           i++; // increment to move position in array
        }

        String binaryNum = "";
        for (int j = i - 1; j >= 0 ; j--) { // reverse order of array and ads it to string
            binaryNum += binaryAr[j];
        }
        return binaryNum;
    }

    public static String toHex(int n) {
        char[] hexAr = new char[100];
        int i = 0;
        while(n > 0) {
            int temp = 0;
            temp = n % 16; //Set temp to remainder
            if (temp < 10) { // if less than 10 assign position array i to char value of 0-9
                hexAr[i] = (char)(temp + 48);
                i++;
            } else {
                hexAr[i] = (char) (temp + 55); // if 10 or more assign position i to char value of A-F
                i++;
            }
            n /= 16; //set new value of n
        }

        String hexNum = "";
        for (int j = i - 1; j >= 0 ; j--) { // Reverse array and concatenate to string
            hexNum += hexAr[j];
        }
        return hexNum;
    }

    public static int binaryToDecimal(String binaryValue) {
        String num = binaryValue;
        int decNum= 0;
        int base = 1;
        int len = num.length();
        for (int i = len - 1; i >= 0 ; i--) { //Revers order through characters of string and adds value of 2^i
            if (num.charAt(i) == '1') {
                decNum += base;
            }
                base *= 2; //increments the power
        }
        return decNum;
    }

    public static int hexToDecimal(String hexValue) {
        int len = hexValue.length();
        int base = 1;
        int decNum = 0;
        for (int i = len - 1; i >= 0; i--) { // traverses string in reverse order
            if (hexValue.charAt(i) >= '0' && hexValue.charAt(i) <= '9') {
                decNum += (hexValue.charAt(i) - 48) * base; //Gets value between 0-9 and multiples that by 16^i
                base *= 16; //increments to power
            } else if (hexValue.charAt(i) >= 'A' && hexValue.charAt(i) <= 'F') {
                decNum += (hexValue.charAt(i) - 55) * base; //Gets value between 10-15 and multiples by 16^i
                base *= 16;
            }
        }
        return decNum;
    }

    // Simple method for decimal addition
    public static int Add(int num1, int num2) {
        return num1 + num2;
    }

    // Simple method for decimal Subtraction
    public static int Subtract(int num1, int num2) {
        return num1 - num2;
    }

    // Simple method for decimal Multiplication
    public static int Multiply(int num1, int num2) {
        return num1 * num2;
    }

    // Simple method for decimal Division
    public static int Division(int num1, int num2) {
        return num1 / num2;
    }
}
