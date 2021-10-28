package Calculator;
public class BinaryConverter extends Conversions {
    @Override
    public int toDecimal(String binaryNum) { return Integer.parseInt(binaryNum, 2); }

    public String toBinary(int decNum) { return Integer.toBinaryString(decNum); }
}
