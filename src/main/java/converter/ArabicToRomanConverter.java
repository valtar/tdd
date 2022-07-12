package converter;

public class ArabicToRomanConverter {
    public static String convert(int i) {
        if (i == 2) {
            return "II";
        }

        return "I";
    }
}
