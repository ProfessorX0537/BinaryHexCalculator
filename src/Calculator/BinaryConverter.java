package Calculator;
public class BinaryConverter extends Conversions {
    @Override // Overrides method from Conversions class to convert to decimal
    public int toDecimal(String binaryNum) { return Integer.parseInt(binaryNum, 2); }

    // Converts decimal values to binary values
    public String toBinary(int decNum) { return Integer.toBinaryString(decNum); }
}
