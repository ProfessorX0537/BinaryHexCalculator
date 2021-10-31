package Calculator;
import java.util.Scanner;
public class CLI {
    //Has 70 lines w/o spaces and lines w/only {}
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        HexConverter hex = new HexConverter();
        BinaryConverter bin = new BinaryConverter();
        Operations math = new Operations();

        // Command Line Interface
        System.out.println("Binary/Hexadecimal Calculator");
        System.out.println("If you want to perform Binary calculation enter 1, for Hex enter 2.");
        System.out.println("Or, you also have the option to convert binary or hex to decimal for this option enter 3.\nEnter: ");
        int calc = scn.nextInt();

        if(calc == 1) {
            // Command Line Interface
            System.out.println("Chose an operation, 1: addition, 2: subtraction, 3: Division, 4: Multiplication" + "\nEnter: ");
            int op = scn.nextInt();
            System.out.println("Enter two Binary values\nValue 1: \nValue 2: ");
            String num1 = scn.next();
            String num2 = scn.next();

            // Cases that call classes to preform binary (addition, subtraction, division, multiplication)
            switch (op) {
                case 1 -> System.out.println(bin.toBinary(math.add(bin.toDecimal(num1), bin.toDecimal(num2))));
                case 2 -> System.out.println(bin.toBinary(math.subtract(bin.toDecimal(num1), bin.toDecimal(num2))));
                case 3 -> System.out.println(bin.toBinary(math.divide(bin.toDecimal(num1), bin.toDecimal(num2))));
                case 4 -> System.out.println(bin.toBinary(math.multiply(bin.toDecimal(num1), bin.toDecimal(num2))));
                default -> System.out.println("Oops! Didn't pick an operation.");
            }
        } else if (calc == 2) {
            // Command Line Interface
            System.out.println("Chose an operation, 1: addition, 2: subtraction, 3: Division, 4: Multiplication" + "\nEnter: ");
            int op = scn.nextInt();
            System.out.println("Enter two Hex values\nValue 1: \nValue 2: ");
            String num1 = scn.next();
            String num2 = scn.next();

            // Cases that call classes to preform hex (addition, subtraction, division, multiplication)
            switch (op) {
                case 1 -> System.out.println(hex.toHex(math.add(hex.toDecimal(num1), hex.toDecimal(num2))));
                case 2 -> System.out.println(hex.toHex(math.subtract(hex.toDecimal(num1), hex.toDecimal(num2))));
                case 3 -> System.out.println(hex.toHex(math.divide(hex.toDecimal(num1), hex.toDecimal(num2))));
                case 4 -> System.out.println(hex.toHex(math.multiply(hex.toDecimal(num1), hex.toDecimal(num2))));
                default -> System.out.println("Oops! Didn't pick an operation.");
            }
        } else {
            //Command Line Interface
            System.out.println("Binary to decimal enter: 1\nDecimal to Binary enter: 2\nHex to decimal enter: 3\nDecimal to hex enter: 4\nEnter:");
            int conType = scn.nextInt();
            System.out.println("Enter value to be converted:");
            String t = scn.nextLine(); // This makes no sense but w/o program won't recognize value scanner
            String value = scn.nextLine();

            // Converts binary/hex values to decimal
            if (conType == 1 || conType == 3) {
                switch (conType) {
                    case 1 -> System.out.println(bin.toDecimal(value));
                    case 3 -> System.out.println(hex.toDecimal(value));
                }
            } else {
            // Converts decimal values into binary/hex values
                switch (conType) {
                    case 2 -> System.out.println(bin.toBinary(Integer.parseInt(value)));
                    case 4 -> System.out.println(hex.toHex(Integer.parseInt(value)));
                }
            }
        }
    }
}
