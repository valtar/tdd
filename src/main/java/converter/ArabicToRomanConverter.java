package converter;

public class ArabicToRomanConverter {
    public static String convert(int i) {
        if (i == 5) {
            return "V";
        }

        return "I".repeat(i);
    }
}
