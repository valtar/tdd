package converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterShould {

    @Test
    void convert1toI() {
        String actualResult = ArabicToRomanConverter.convert(1);

        assertEquals("I", actualResult);
    }
}
