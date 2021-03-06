package converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterShould {

    @Test
    void convert1toI() {
        String actualResult = ArabicToRomanConverter.convert(1);

        assertEquals("I", actualResult);
    }

    @Test
    void convert2toII() {
        String actualResult = ArabicToRomanConverter.convert(2);

        assertEquals("II", actualResult);
    }

    @Test
    void convert3toIII() {
        String actualResult = ArabicToRomanConverter.convert(3);

        assertEquals("III", actualResult);
    }

    @Test
    void convert5toV() {
        String actualResult = ArabicToRomanConverter.convert(5);

        assertEquals("V", actualResult);
    }

    @Test
    void convert10toX() {
        String actualResult = ArabicToRomanConverter.convert(10);

        assertEquals("X", actualResult);
    }
}
