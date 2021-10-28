package Calculator;
public class HexConverter extends Conversions {
    @Override
    public int toDecimal(String hexNum) { return Integer.parseInt(hexNum, 16); }

    public String toHex(int decNum) { return Integer.toHexString(decNum); }
}
