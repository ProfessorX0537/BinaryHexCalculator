package Calculator;
public class HexConverter extends Conversions {
    @Override // Overrides method from Conversion abstract super class
    public int toDecimal(String hexNum) { return Integer.parseInt(hexNum, 16); }

    // Converts decimal values to hex
    public String toHex(int decNum) { return Integer.toHexString(decNum); }
}
