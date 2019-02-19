import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MiscellaneousTest {

    static final char capitalA = 'A';

    @Test
    public void char_as_num() {
        assertEquals(65, capitalA);
    }

    @Test public void concatenate() {
        assertEquals("abcdef", "abc" + "def");
    }
}
